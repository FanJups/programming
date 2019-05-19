namespace TextToSpeech
{
    partial class TextToSpeech
    {
        /// <summary>
        /// Variable nécessaire au concepteur.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Nettoyage des ressources utilisées.
        /// </summary>
        /// <param name="disposing">true si les ressources managées doivent être supprimées ; sinon, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Code généré par le Concepteur Windows Form

        /// <summary>
        /// Méthode requise pour la prise en charge du concepteur - ne modifiez pas
        /// le contenu de cette méthode avec l'éditeur de code.
        /// </summary>
        private void InitializeComponent()
        {
            this.champtexte = new System.Windows.Forms.RichTextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.stop = new System.Windows.Forms.Button();
            this.reprendre = new System.Windows.Forms.Button();
            this.pause = new System.Windows.Forms.Button();
            this.lectureasynchrone = new System.Windows.Forms.Button();
            this.g = new System.Windows.Forms.GroupBox();
            this.lecturesynchrone = new System.Windows.Forms.Button();
            this.encoreplusloin = new System.Windows.Forms.GroupBox();
            this.verificationetatlecture = new System.Windows.Forms.GroupBox();
            this.etat = new System.Windows.Forms.TextBox();
            this.etatbutton = new System.Windows.Forms.Button();
            this.listevoixinstordi = new System.Windows.Forms.GroupBox();
            this.malistbox = new System.Windows.Forms.ListBox();
            this.listerlesvoix = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.g.SuspendLayout();
            this.encoreplusloin.SuspendLayout();
            this.verificationetatlecture.SuspendLayout();
            this.listevoixinstordi.SuspendLayout();
            this.SuspendLayout();
            // 
            // champtexte
            // 
            this.champtexte.BackColor = System.Drawing.Color.DarkOrange;
            this.champtexte.Location = new System.Drawing.Point(12, 12);
            this.champtexte.Name = "champtexte";
            this.champtexte.Size = new System.Drawing.Size(911, 144);
            this.champtexte.TabIndex = 0;
            this.champtexte.Text = "Bonjour, je m\'appelle Fanona, le robot de Fanon. C\'est mon créateur. Je ne suis p" +
    "as encore prêt pour l\'instant. Fanon doit dormir pour me faire grandir. Oh le gr" +
    "and Fanon !";
            this.champtexte.TextChanged += new System.EventHandler(this.champtexte_TextChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.Orange;
            this.groupBox1.Controls.Add(this.groupBox3);
            this.groupBox1.Controls.Add(this.g);
            this.groupBox1.Location = new System.Drawing.Point(12, 162);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(911, 124);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Action sur la lecture :";
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.stop);
            this.groupBox3.Controls.Add(this.reprendre);
            this.groupBox3.Controls.Add(this.pause);
            this.groupBox3.Controls.Add(this.lectureasynchrone);
            this.groupBox3.Location = new System.Drawing.Point(242, 19);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(633, 99);
            this.groupBox3.TabIndex = 1;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Méthode asynchrone :";
            // 
            // stop
            // 
            this.stop.Location = new System.Drawing.Point(479, 56);
            this.stop.Name = "stop";
            this.stop.Size = new System.Drawing.Size(75, 23);
            this.stop.TabIndex = 3;
            this.stop.Text = "stop";
            this.stop.UseVisualStyleBackColor = true;
            this.stop.Click += new System.EventHandler(this.stop_Click);
            // 
            // reprendre
            // 
            this.reprendre.Location = new System.Drawing.Point(319, 56);
            this.reprendre.Name = "reprendre";
            this.reprendre.Size = new System.Drawing.Size(90, 23);
            this.reprendre.TabIndex = 2;
            this.reprendre.Text = "reprendre";
            this.reprendre.UseVisualStyleBackColor = true;
            this.reprendre.Click += new System.EventHandler(this.reprendre_Click);
            // 
            // pause
            // 
            this.pause.Location = new System.Drawing.Point(185, 56);
            this.pause.Name = "pause";
            this.pause.Size = new System.Drawing.Size(93, 23);
            this.pause.TabIndex = 1;
            this.pause.Text = "pause";
            this.pause.UseVisualStyleBackColor = true;
            this.pause.Click += new System.EventHandler(this.pause_Click);
            // 
            // lectureasynchrone
            // 
            this.lectureasynchrone.Location = new System.Drawing.Point(25, 56);
            this.lectureasynchrone.Name = "lectureasynchrone";
            this.lectureasynchrone.Size = new System.Drawing.Size(121, 23);
            this.lectureasynchrone.TabIndex = 0;
            this.lectureasynchrone.Text = "Voix anglaise";
            this.lectureasynchrone.UseVisualStyleBackColor = true;
            this.lectureasynchrone.Click += new System.EventHandler(this.lectureasynchrone_Click);
            // 
            // g
            // 
            this.g.Controls.Add(this.lecturesynchrone);
            this.g.Location = new System.Drawing.Point(16, 19);
            this.g.Name = "g";
            this.g.Size = new System.Drawing.Size(220, 99);
            this.g.TabIndex = 0;
            this.g.TabStop = false;
            this.g.Text = "Méthode synchrone :";
            this.g.Enter += new System.EventHandler(this.groupBox2_Enter);
            // 
            // lecturesynchrone
            // 
            this.lecturesynchrone.Location = new System.Drawing.Point(31, 56);
            this.lecturesynchrone.Name = "lecturesynchrone";
            this.lecturesynchrone.Size = new System.Drawing.Size(150, 23);
            this.lecturesynchrone.TabIndex = 0;
            this.lecturesynchrone.Text = "Voix française";
            this.lecturesynchrone.UseVisualStyleBackColor = true;
            this.lecturesynchrone.Click += new System.EventHandler(this.button1_Click);
            // 
            // encoreplusloin
            // 
            this.encoreplusloin.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(128)))));
            this.encoreplusloin.Controls.Add(this.verificationetatlecture);
            this.encoreplusloin.Controls.Add(this.listevoixinstordi);
            this.encoreplusloin.Location = new System.Drawing.Point(12, 292);
            this.encoreplusloin.Name = "encoreplusloin";
            this.encoreplusloin.Size = new System.Drawing.Size(911, 157);
            this.encoreplusloin.TabIndex = 2;
            this.encoreplusloin.TabStop = false;
            this.encoreplusloin.Text = "Encore plus loin : ";
            this.encoreplusloin.Enter += new System.EventHandler(this.encoreplusloin_Enter);
            // 
            // verificationetatlecture
            // 
            this.verificationetatlecture.Controls.Add(this.etat);
            this.verificationetatlecture.Controls.Add(this.etatbutton);
            this.verificationetatlecture.Location = new System.Drawing.Point(338, 23);
            this.verificationetatlecture.Name = "verificationetatlecture";
            this.verificationetatlecture.Size = new System.Drawing.Size(363, 128);
            this.verificationetatlecture.TabIndex = 1;
            this.verificationetatlecture.TabStop = false;
            this.verificationetatlecture.Text = "Vérification de l\'état de lecture :";
            this.verificationetatlecture.Enter += new System.EventHandler(this.verificationetatlecture_Enter);
            // 
            // etat
            // 
            this.etat.Location = new System.Drawing.Point(127, 48);
            this.etat.Name = "etat";
            this.etat.Size = new System.Drawing.Size(100, 20);
            this.etat.TabIndex = 1;
            this.etat.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // etatbutton
            // 
            this.etatbutton.Location = new System.Drawing.Point(18, 45);
            this.etatbutton.Name = "etatbutton";
            this.etatbutton.Size = new System.Drawing.Size(86, 23);
            this.etatbutton.TabIndex = 0;
            this.etatbutton.Text = "etat";
            this.etatbutton.UseVisualStyleBackColor = true;
            this.etatbutton.Click += new System.EventHandler(this.etat_Click);
            // 
            // listevoixinstordi
            // 
            this.listevoixinstordi.Controls.Add(this.malistbox);
            this.listevoixinstordi.Controls.Add(this.listerlesvoix);
            this.listevoixinstordi.Location = new System.Drawing.Point(6, 23);
            this.listevoixinstordi.Name = "listevoixinstordi";
            this.listevoixinstordi.Size = new System.Drawing.Size(296, 128);
            this.listevoixinstordi.TabIndex = 0;
            this.listevoixinstordi.TabStop = false;
            this.listevoixinstordi.Text = "Liste des voix installée sur l\'ordinateur";
            this.listevoixinstordi.Enter += new System.EventHandler(this.groupBox2_Enter_1);
            // 
            // malistbox
            // 
            this.malistbox.FormattingEnabled = true;
            this.malistbox.Location = new System.Drawing.Point(101, 19);
            this.malistbox.Name = "malistbox";
            this.malistbox.Size = new System.Drawing.Size(189, 95);
            this.malistbox.TabIndex = 1;
            this.malistbox.SelectedIndexChanged += new System.EventHandler(this.malistbox_SelectedIndexChanged);
            // 
            // listerlesvoix
            // 
            this.listerlesvoix.Location = new System.Drawing.Point(10, 19);
            this.listerlesvoix.Name = "listerlesvoix";
            this.listerlesvoix.Size = new System.Drawing.Size(75, 23);
            this.listerlesvoix.TabIndex = 0;
            this.listerlesvoix.Text = "lister les voix";
            this.listerlesvoix.UseVisualStyleBackColor = true;
            this.listerlesvoix.Click += new System.EventHandler(this.listerlesvoix_Click);
            // 
            // TextToSpeech
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = global::TextToSpeech.Properties.Resources.perroquet;
            this.ClientSize = new System.Drawing.Size(935, 461);
            this.Controls.Add(this.encoreplusloin);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.champtexte);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "TextToSpeech";
            this.Text = "Repeat every time";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox3.ResumeLayout(false);
            this.g.ResumeLayout(false);
            this.encoreplusloin.ResumeLayout(false);
            this.verificationetatlecture.ResumeLayout(false);
            this.verificationetatlecture.PerformLayout();
            this.listevoixinstordi.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.RichTextBox champtexte;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox g;
        private System.Windows.Forms.Button lecturesynchrone;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button lectureasynchrone;
        private System.Windows.Forms.Button stop;
        private System.Windows.Forms.Button reprendre;
        private System.Windows.Forms.Button pause;
        private System.Windows.Forms.GroupBox encoreplusloin;
        private System.Windows.Forms.GroupBox listevoixinstordi;
        private System.Windows.Forms.Button listerlesvoix;
        private System.Windows.Forms.ListBox malistbox;
        private System.Windows.Forms.GroupBox verificationetatlecture;
        private System.Windows.Forms.Button etatbutton;
        private System.Windows.Forms.TextBox etat;
    }
}

