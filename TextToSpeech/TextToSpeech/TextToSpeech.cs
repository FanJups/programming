using System;
using System.Windows;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Speech;
using System.Speech.Synthesis;

//Microsoft Zira Desktop : voix anglaise 

namespace TextToSpeech
{
    public partial class TextToSpeech : Form
    {
        public SpeechSynthesizer parole = new SpeechSynthesizer();
        public TextToSpeech()
        {
            InitializeComponent();
        }

        public bool verifvoix(string voix)
        {
            foreach(InstalledVoice unevoix in parole.GetInstalledVoices())
            //Je liste les voix installées
            {
                if (unevoix.VoiceInfo.Name == voix)
                    // Je vérifie ici que la voix est égale à celle de la variable voix
                    return true;// Si la voix correspond bien alors la fonction retourne true
            }

            return false;// Je renvoie la valeur false si la voix ne correspond pas
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void champtexte_TextChanged(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void groupBox2_Enter(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            //string voix = "ScanSoft Virginie_Dri40_16kHz";

            string voix = "Microsoft Hortense Desktop";

            if (verifvoix(voix)) // Si la voix est installée
                parole.SelectVoice(voix); // Alors on l'utilise //appel de la fonction verifvoix avec la voix de Virginie en argument
            parole.Speak(champtexte.Text); //lecture du texte
        }

        private void lectureasynchrone_Click(object sender, EventArgs e)
        {
            string voix = "Microsoft Zira Desktop";

            if (verifvoix(voix)) // Si la voix est installée
                parole.SelectVoice(voix); // Alors on l'utilise //appel de la fonction verifvoix avec la voix de Virginie en argument
            parole.SpeakAsync(champtexte.Text); //lecture du texte
        }

        private void pause_Click(object sender, EventArgs e)
        {
            parole.Pause();

        }

        private void reprendre_Click(object sender, EventArgs e)
        {
            parole.Resume();
        }

        private void stop_Click(object sender, EventArgs e)
        {
            parole.SpeakAsyncCancelAll();
        }

        private void encoreplusloin_Enter(object sender, EventArgs e)
        {

        }

        private void groupBox2_Enter_1(object sender, EventArgs e)
        {

        }

        private void listerlesvoix_Click(object sender, EventArgs e)
        {
            foreach(InstalledVoice unevoix in parole.GetInstalledVoices())
            {
                malistbox.Items.Add(unevoix.VoiceInfo.Name);
            }
        }

        private void malistbox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void verificationetatlecture_Enter(object sender, EventArgs e)
        {

        }

        private void etat_Click(object sender, EventArgs e)
        {
            switch (parole.State)
            {
                case SynthesizerState.Ready:
                    etat.Text = "Ready";
                    break;

                case SynthesizerState.Speaking:
                    etat.Text = "Speaking";
                    break;

                case SynthesizerState.Paused:
                    etat.Text = "Paused";
                    break;
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            
        }
    }
}
