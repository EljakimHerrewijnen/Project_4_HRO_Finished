namespace Parser_Project_4
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.newFileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.parseCSVFileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.fietsenDiefstalToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.fietsenTrommelsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.parseFileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveAsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aboutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.TB_IPaddr = new System.Windows.Forms.TextBox();
            this.TB_Port = new System.Windows.Forms.TextBox();
            this.TB_Datab = new System.Windows.Forms.TextBox();
            this.TB_Uname = new System.Windows.Forms.TextBox();
            this.TB_Pass = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
            this.button2 = new System.Windows.Forms.Button();
            this.Btn_TestConnection = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.aboutToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(500, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newFileToolStripMenuItem,
            this.parseCSVFileToolStripMenuItem,
            this.parseFileToolStripMenuItem,
            this.exitToolStripMenuItem,
            this.saveAsToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // newFileToolStripMenuItem
            // 
            this.newFileToolStripMenuItem.Name = "newFileToolStripMenuItem";
            this.newFileToolStripMenuItem.Size = new System.Drawing.Size(181, 22);
            this.newFileToolStripMenuItem.Text = "New File";
            this.newFileToolStripMenuItem.Click += new System.EventHandler(this.newFileToolStripMenuItem_Click);
            // 
            // parseCSVFileToolStripMenuItem
            // 
            this.parseCSVFileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fietsenDiefstalToolStripMenuItem,
            this.fietsenTrommelsToolStripMenuItem});
            this.parseCSVFileToolStripMenuItem.Name = "parseCSVFileToolStripMenuItem";
            this.parseCSVFileToolStripMenuItem.Size = new System.Drawing.Size(181, 22);
            this.parseCSVFileToolStripMenuItem.Text = "Parse .CSV File";
            this.parseCSVFileToolStripMenuItem.Click += new System.EventHandler(this.parseCSVFileToolStripMenuItem_Click);
            // 
            // fietsenDiefstalToolStripMenuItem
            // 
            this.fietsenDiefstalToolStripMenuItem.Name = "fietsenDiefstalToolStripMenuItem";
            this.fietsenDiefstalToolStripMenuItem.Size = new System.Drawing.Size(164, 22);
            this.fietsenDiefstalToolStripMenuItem.Text = "FietsenDiefstal";
            this.fietsenDiefstalToolStripMenuItem.Click += new System.EventHandler(this.fietsenDiefstalToolStripMenuItem_Click);
            // 
            // fietsenTrommelsToolStripMenuItem
            // 
            this.fietsenTrommelsToolStripMenuItem.Name = "fietsenTrommelsToolStripMenuItem";
            this.fietsenTrommelsToolStripMenuItem.Size = new System.Drawing.Size(164, 22);
            this.fietsenTrommelsToolStripMenuItem.Text = "FietsenTrommels";
            this.fietsenTrommelsToolStripMenuItem.Click += new System.EventHandler(this.fietsenTrommelsToolStripMenuItem_Click);
            // 
            // parseFileToolStripMenuItem
            // 
            this.parseFileToolStripMenuItem.Name = "parseFileToolStripMenuItem";
            this.parseFileToolStripMenuItem.Size = new System.Drawing.Size(181, 22);
            this.parseFileToolStripMenuItem.Text = "Parse .XLS File(Slow)";
            this.parseFileToolStripMenuItem.Click += new System.EventHandler(this.parseFileToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(181, 22);
            this.exitToolStripMenuItem.Text = "Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
            // 
            // saveAsToolStripMenuItem
            // 
            this.saveAsToolStripMenuItem.Name = "saveAsToolStripMenuItem";
            this.saveAsToolStripMenuItem.Size = new System.Drawing.Size(181, 22);
            this.saveAsToolStripMenuItem.Text = "Save as";
            // 
            // aboutToolStripMenuItem
            // 
            this.aboutToolStripMenuItem.Name = "aboutToolStripMenuItem";
            this.aboutToolStripMenuItem.Size = new System.Drawing.Size(52, 20);
            this.aboutToolStripMenuItem.Text = "About";
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(13, 28);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.textBox1.Size = new System.Drawing.Size(477, 218);
            this.textBox1.TabIndex = 1;
            // 
            // TB_IPaddr
            // 
            this.TB_IPaddr.Location = new System.Drawing.Point(105, 252);
            this.TB_IPaddr.Name = "TB_IPaddr";
            this.TB_IPaddr.Size = new System.Drawing.Size(100, 20);
            this.TB_IPaddr.TabIndex = 2;
            this.TB_IPaddr.Text = "localhost";
            // 
            // TB_Port
            // 
            this.TB_Port.Location = new System.Drawing.Point(105, 278);
            this.TB_Port.Name = "TB_Port";
            this.TB_Port.Size = new System.Drawing.Size(100, 20);
            this.TB_Port.TabIndex = 3;
            this.TB_Port.Text = "5432";
            // 
            // TB_Datab
            // 
            this.TB_Datab.Location = new System.Drawing.Point(105, 304);
            this.TB_Datab.Name = "TB_Datab";
            this.TB_Datab.Size = new System.Drawing.Size(100, 20);
            this.TB_Datab.TabIndex = 4;
            this.TB_Datab.Text = "Fietsendiefstal";
            // 
            // TB_Uname
            // 
            this.TB_Uname.Location = new System.Drawing.Point(297, 252);
            this.TB_Uname.Name = "TB_Uname";
            this.TB_Uname.Size = new System.Drawing.Size(100, 20);
            this.TB_Uname.TabIndex = 5;
            this.TB_Uname.Text = "Postgres";
            // 
            // TB_Pass
            // 
            this.TB_Pass.Location = new System.Drawing.Point(297, 281);
            this.TB_Pass.Name = "TB_Pass";
            this.TB_Pass.Size = new System.Drawing.Size(100, 20);
            this.TB_Pass.TabIndex = 6;
            this.TB_Pass.Text = "password";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 259);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(78, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Server address";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 281);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 13);
            this.label2.TabIndex = 8;
            this.label2.Text = "Server Port";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 307);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(87, 13);
            this.label3.TabIndex = 9;
            this.label3.Text = "Server Database";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(222, 255);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(55, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Username";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(222, 281);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(53, 13);
            this.label5.TabIndex = 11;
            this.label5.Text = "Password";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(12, 339);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(125, 23);
            this.button1.TabIndex = 12;
            this.button1.Text = "Send to database";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(413, 250);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 48);
            this.button2.TabIndex = 15;
            this.button2.Text = "Copy to clipboard";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // Btn_TestConnection
            // 
            this.Btn_TestConnection.Location = new System.Drawing.Point(225, 307);
            this.Btn_TestConnection.Name = "Btn_TestConnection";
            this.Btn_TestConnection.Size = new System.Drawing.Size(115, 23);
            this.Btn_TestConnection.TabIndex = 16;
            this.Btn_TestConnection.Text = "Test Connection";
            this.Btn_TestConnection.UseVisualStyleBackColor = true;
            this.Btn_TestConnection.Click += new System.EventHandler(this.Btn_TestConnection_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(500, 383);
            this.Controls.Add(this.Btn_TestConnection);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.TB_Pass);
            this.Controls.Add(this.TB_Uname);
            this.Controls.Add(this.TB_Datab);
            this.Controls.Add(this.TB_Port);
            this.Controls.Add(this.TB_IPaddr);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.menuStrip1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Xls File Parser";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newFileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem parseFileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem aboutToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem saveAsToolStripMenuItem;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox TB_IPaddr;
        private System.Windows.Forms.TextBox TB_Port;
        private System.Windows.Forms.TextBox TB_Datab;
        private System.Windows.Forms.TextBox TB_Uname;
        private System.Windows.Forms.TextBox TB_Pass;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.SaveFileDialog saveFileDialog1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.ToolStripMenuItem parseCSVFileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem fietsenDiefstalToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem fietsenTrommelsToolStripMenuItem;
        private System.Windows.Forms.Button Btn_TestConnection;
    }
}

