<?php
namespace App\Frontend\Modules\News;

use \OCFram\BackController;
use \OCFram\HTTPRequest;
use \Entity\Comment;
use \FormBuilder\CommentFormBuilder;
use \OCFram\FormHandler;
use \OCFram\Cache;

define('ROOT',  dirname(dirname(dirname(dirname(dirname(__FILE__)))))  ) ; //  Se placer à la racine du dossier

class NewsController extends BackController
{
  
  public function createCache()
  {
    // Tableau nom de la vue et durée en minutes

    return array('index.php' => 5 , 'layout.php' => 5 );


  }

  public function executeIndex(HTTPRequest $request)
  {
    $nombreNews = $this->app->config()->get('nombre_news');
    $nombreCaracteres = $this->app->config()->get('nombre_caracteres');
    
    // On ajoute une définition pour le titre.
    $this->page->addVar('title', 'Liste des '.$nombreNews.' dernières news');
    
    // On récupère le manager des news.
    $manager = $this->managers->getManagerOf('News');
    
    $listeNews = $manager->getList(0, $nombreNews);
    
    foreach ($listeNews as $news)
    {
      
        // Début de la gestion du cache News_id_dateAjout_dateModif

      

        $cache = new Cache(ROOT.'/tmp/cache/datas',5);

        $dateString = $news['dateAjout']->format('Y-m-d-H-i-s');

        $dateModifString = $news['dateModif']->format('Y-m-d-H-i-s');

        $krr = explode('-',$dateString);

        $dateString = implode("_", $krr);

        $krr2 = explode('-',$dateModifString);

        $dateModifString = implode("_", $krr2);

        $name = "News_".$news['id']."_".$dateString."_".$dateModifString;

        if( $iscache =  $cache->read($name)) // Je ne  mets pas en cache si c'est  en cache , je peux l'utiliser directement
        {
          if (strlen($iscache) > $nombreCaracteres)
          {
            $debut = substr($iscache, 0, $nombreCaracteres);
            $debut = substr($debut, 0, strrpos($debut, ' ')) . '...';
        
            $news->setContenu($debut);
          }
        }
        else // Je mets  en cache si c'est pas  en cache et j'utilise ma bdd
        {
          $cache->write($name,$news['contenu']);

          if (strlen($news->contenu()) > $nombreCaracteres)
          {
            $debut = substr($news->contenu(), 0, $nombreCaracteres);
            $debut = substr($debut, 0, strrpos($debut, ' ')) . '...';
        
            $news->setContenu($debut);
          }
        }

        // Fin de la gestion du cache

      
    }
    
    // On ajoute la variable $listeNews à la vue.
    $this->page->addVar('listeNews', $listeNews);

  }
  
  public function executeShow(HTTPRequest $request)
  {
    $news = $this->managers->getManagerOf('News')->getUnique($request->getData('id'));
    
    if (empty($news))
    {
      $this->app->httpResponse()->redirect404();
    }
    
    $this->page->addVar('title', $news->titre());
    $this->page->addVar('news', $news);

    // Début de la gestion du cache Comments_idnews_id_date

    $listeComments = $this->managers->getManagerOf('Comments')->getListOf($news->id()) ;

    foreach ($listeComments as $comments)
    {
        $cache = new Cache(ROOT.'/tmp/cache/datas',5);

        $dateString = $comments['date']->format('Y-m-d-H-i-s');

        $krr = explode('-',$dateString);

        $dateString = implode("_", $krr);

        $name = "Comments_".$comments['news']."_".$comments['id']."_".$dateString;

        if( $iscache =  $cache->read($name))
        {
          $comments['contenu'] = $iscache;
        }
        else
        {
          $cache->write($name,$comments['contenu']);
        }
    }

    // Fin de la gestion du cache Comments_idnews_id_date


    $this->page->addVar('comments', $listeComments);
  }

  public function executeInsertComment(HTTPRequest $request)
  {
    // Si le formulaire a été envoyé.
    if ($request->method() == 'POST')
    {
      $comment = new Comment([
        'news' => $request->getData('news'),
        'auteur' => $request->postData('auteur'),
        'contenu' => $request->postData('contenu') 
      ]);
    }
    else
    {
      $comment = new Comment;
    }

    $formBuilder = new CommentFormBuilder($comment);
    $formBuilder->build();

    $form = $formBuilder->form();

    $formHandler = new FormHandler($form, $this->managers->getManagerOf('Comments'), $request);

    if ($formHandler->process())
    {
      $this->app->user()->setFlash('Le commentaire a bien été ajouté, merci !');
      
      $this->app->httpResponse()->redirect('news-'.$request->getData('news').'.html');
    }

    $this->page->addVar('comment', $comment);
    $this->page->addVar('form', $form->createView());
    $this->page->addVar('title', 'Ajout d\'un commentaire');
  }
}