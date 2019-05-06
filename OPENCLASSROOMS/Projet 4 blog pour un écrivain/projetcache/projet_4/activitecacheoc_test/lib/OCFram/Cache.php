<?php

namespace OCFram;

/*

	Attributs :

		- date d'expiration

		- répertoire

	Méthodes :

*/

	class Cache
	{
		protected $dirname;

		protected $duration; // Durée de vie du cache en minutes

		public function __construct($dirname,$duration)
		{
			$this->dirname = $dirname;

			$this->duration = $duration;
		}

		public function write ($filename,$content)
		{
			
			$data = $this->duration."\n".$content;

			//Je crée une copie qui contient uniquement le content

			file_put_contents($this->dirname.'/'.$filename.'_copie', serialize($content),FILE_APPEND);

			return file_put_contents($this->dirname.'/'.$filename, serialize($data),FILE_APPEND);
		}

		public function read ($filename)
		{
			$file = $this->dirname.'/'.$filename;

			$file_copy = $file.'_copie';

			if(file_exists($file))
			{
				$lifetime = (time() - filemtime($file))/60;

				if($lifetime > $this->duration)
				{
					//Je supprime le fichier et sa copie

					$this->delete($filename.'_copie');

					$this->delete($filename);

					return false;
				}
				else
				{
					// Je ne supprime pas et j'envoie la copie

					
					return unserialize(file_get_contents($file_copy)) ;
				}
			}
			else
			{
				// Si le fichier n'existe pas je ne retourne rien

				return false;
			}
		}


		public function delete($filename)
		{
			$file = $this->dirname.'/'.$filename;

			if(file_exists($file))
			{
				unlink($file);
			}
		}


		public function clear()
		{
			$files = glob($this->dirname.'/*');

			foreach ($files as $file )
			{
				unlink($file);
			}
		}




	}