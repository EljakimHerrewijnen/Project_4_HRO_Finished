namespace Parser_v2
{
    partial class ParserGUI
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
            this.TB_Input = new System.Windows.Forms.TextBox();
            this.TB_Output = new System.Windows.Forms.TextBox();
            this.TB_ServerAddr = new System.Windows.Forms.TextBox();
            this.TB_ServerUpass = new System.Windows.Forms.TextBox();
            this.TB_ServerUname = new System.Windows.Forms.TextBox();
            this.TB_DataName = new System.Windows.Forms.TextBox();
            this.TB_ServerPort = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.LB_ServerConnected = new System.Windows.Forms.Label();
            this.Btn_Copy_Input = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.newFileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.restartToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.button6 = new System.Windows.Forms.Button();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.checkBox2 = new System.Windows.Forms.CheckBox();
            this.checkBox3 = new System.Windows.Forms.CheckBox();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // TB_Input
            // 
            this.TB_Input.Location = new System.Drawing.Point(12, 27);
            this.TB_Input.Multiline = true;
            this.TB_Input.Name = "TB_Input";
            this.TB_Input.Size = new System.Drawing.Size(426, 315);
            this.TB_Input.TabIndex = 0;
            // 
            // TB_Output
            // 
            this.TB_Output.Location = new System.Drawing.Point(456, 27);
            this.TB_Output.Multiline = true;
            this.TB_Output.Name = "TB_Output";
            this.TB_Output.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.TB_Output.Size = new System.Drawing.Size(630, 315);
            this.TB_Output.TabIndex = 1;
            // 
            // TB_ServerAddr
            // 
            this.TB_ServerAddr.Location = new System.Drawing.Point(13, 379);
            this.TB_ServerAddr.Name = "TB_ServerAddr";
            this.TB_ServerAddr.Size = new System.Drawing.Size(100, 20);
            this.TB_ServerAddr.TabIndex = 2;
            this.TB_ServerAddr.Text = "localhost";
            // 
            // TB_ServerUpass
            // 
            this.TB_ServerUpass.Location = new System.Drawing.Point(205, 404);
            this.TB_ServerUpass.Name = "TB_ServerUpass";
            this.TB_ServerUpass.Size = new System.Drawing.Size(100, 20);
            this.TB_ServerUpass.TabIndex = 3;
            this.TB_ServerUpass.Text = "ATest";
            // 
            // TB_ServerUname
            // 
            this.TB_ServerUname.Location = new System.Drawing.Point(205, 378);
            this.TB_ServerUname.Name = "TB_ServerUname";
            this.TB_ServerUname.Size = new System.Drawing.Size(100, 20);
            this.TB_ServerUname.TabIndex = 4;
            this.TB_ServerUname.Text = "postgres";
            // 
            // TB_DataName
            // 
            this.TB_DataName.Location = new System.Drawing.Point(13, 431);
            this.TB_DataName.Name = "TB_DataName";
            this.TB_DataName.Size = new System.Drawing.Size(100, 20);
            this.TB_DataName.TabIndex = 5;
            this.TB_DataName.Text = "Project_3";
            // 
            // TB_ServerPort
            // 
            this.TB_ServerPort.Location = new System.Drawing.Point(13, 405);
            this.TB_ServerPort.Name = "TB_ServerPort";
            this.TB_ServerPort.Size = new System.Drawing.Size(100, 20);
            this.TB_ServerPort.TabIndex = 6;
            this.TB_ServerPort.Text = "5432";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(120, 385);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(79, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Server Address";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(311, 381);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 13);
            this.label2.TabIndex = 8;
            this.label2.Text = "Username";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(311, 407);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 13);
            this.label3.TabIndex = 9;
            this.label3.Text = "Password";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(120, 434);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(84, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Database Name";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(120, 408);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(60, 13);
            this.label5.TabIndex = 11;
            this.label5.Text = "Server Port";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(13, 348);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(139, 23);
            this.button1.TabIndex = 12;
            this.button1.Text = "Clear Textbox";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(636, 348);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(139, 23);
            this.button2.TabIndex = 13;
            this.button2.Text = "Clear Textbox";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(299, 348);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(139, 23);
            this.button3.TabIndex = 14;
            this.button3.Text = "Connect to Database";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(941, 348);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(145, 23);
            this.button4.TabIndex = 15;
            this.button4.Text = "Send Query";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // LB_ServerConnected
            // 
            this.LB_ServerConnected.AutoSize = true;
            this.LB_ServerConnected.Location = new System.Drawing.Point(224, 434);
            this.LB_ServerConnected.Name = "LB_ServerConnected";
            this.LB_ServerConnected.Size = new System.Drawing.Size(140, 13);
            this.LB_ServerConnected.TabIndex = 16;
            this.LB_ServerConnected.Text = "The server is not connected";
            // 
            // Btn_Copy_Input
            // 
            this.Btn_Copy_Input.Location = new System.Drawing.Point(158, 348);
            this.Btn_Copy_Input.Name = "Btn_Copy_Input";
            this.Btn_Copy_Input.Size = new System.Drawing.Size(134, 23);
            this.Btn_Copy_Input.TabIndex = 17;
            this.Btn_Copy_Input.Text = "Copy to clipboard";
            this.Btn_Copy_Input.UseVisualStyleBackColor = true;
            this.Btn_Copy_Input.Click += new System.EventHandler(this.Btn_Copy_Input_Click);
            // 
            // button5
            // 
            this.button5.Location = new System.Drawing.Point(781, 348);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(150, 23);
            this.button5.TabIndex = 18;
            this.button5.Text = "Copy to clipboard";
            this.button5.UseVisualStyleBackColor = true;
            this.button5.Click += new System.EventHandler(this.button5_Click);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(1098, 24);
            this.menuStrip1.TabIndex = 19;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newFileToolStripMenuItem,
            this.restartToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // newFileToolStripMenuItem
            // 
            this.newFileToolStripMenuItem.Name = "newFileToolStripMenuItem";
            this.newFileToolStripMenuItem.Size = new System.Drawing.Size(119, 22);
            this.newFileToolStripMenuItem.Text = "New File";
            this.newFileToolStripMenuItem.Click += new System.EventHandler(this.newFileToolStripMenuItem_Click);
            // 
            // restartToolStripMenuItem
            // 
            this.restartToolStripMenuItem.Name = "restartToolStripMenuItem";
            this.restartToolStripMenuItem.Size = new System.Drawing.Size(119, 22);
            this.restartToolStripMenuItem.Text = "Restart";
            this.restartToolStripMenuItem.Click += new System.EventHandler(this.restartToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(119, 22);
            this.exitToolStripMenuItem.Text = "Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            this.openFileDialog1.FileOk += new System.ComponentModel.CancelEventHandler(this.openFileDialog1_FileOk);
            // 
            // button6
            // 
            this.button6.Location = new System.Drawing.Point(456, 348);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(174, 23);
            this.button6.TabIndex = 20;
            this.button6.Text = "Convert from Input";
            this.button6.UseVisualStyleBackColor = true;
            this.button6.Click += new System.EventHandler(this.button6_Click);
            // 
            // checkBox1
            // 
            this.checkBox1.AutoSize = true;
            this.checkBox1.Location = new System.Drawing.Point(0, 0);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(80, 17);
            this.checkBox1.TabIndex = 21;
            this.checkBox1.Text = "checkBox1";
            this.checkBox1.UseVisualStyleBackColor = true;
            // 
            // checkBox2
            // 
            this.checkBox2.AutoSize = true;
            this.checkBox2.Location = new System.Drawing.Point(411, 385);
            this.checkBox2.Name = "checkBox2";
            this.checkBox2.Size = new System.Drawing.Size(130, 17);
            this.checkBox2.TabIndex = 22;
            this.checkBox2.Text = "Use the default parser";
            this.checkBox2.UseVisualStyleBackColor = true;
            this.checkBox2.CheckedChanged += new System.EventHandler(this.checkBox2_CheckedChanged);
            // 
            // checkBox3
            // 
            this.checkBox3.AutoSize = true;
            this.checkBox3.Location = new System.Drawing.Point(411, 409);
            this.checkBox3.Name = "checkBox3";
            this.checkBox3.Size = new System.Drawing.Size(137, 17);
            this.checkBox3.TabIndex = 23;
            this.checkBox3.Text = "Use parser for Project 4";
            this.checkBox3.UseVisualStyleBackColor = true;
            this.checkBox3.CheckedChanged += new System.EventHandler(this.checkBox3_CheckedChanged);
            // 
            // ParserGUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1098, 467);
            this.Controls.Add(this.checkBox3);
            this.Controls.Add(this.checkBox2);
            this.Controls.Add(this.checkBox1);
            this.Controls.Add(this.button6);
            this.Controls.Add(this.button5);
            this.Controls.Add(this.Btn_Copy_Input);
            this.Controls.Add(this.LB_ServerConnected);
            this.Controls.Add(this.button4);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.TB_ServerPort);
            this.Controls.Add(this.TB_DataName);
            this.Controls.Add(this.TB_ServerUname);
            this.Controls.Add(this.TB_ServerUpass);
            this.Controls.Add(this.TB_ServerAddr);
            this.Controls.Add(this.TB_Output);
            this.Controls.Add(this.TB_Input);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "ParserGUI";
            this.Text = "ParserGUI";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox TB_Input;
        private System.Windows.Forms.TextBox TB_Output;
        private System.Windows.Forms.TextBox TB_ServerAddr;
        private System.Windows.Forms.TextBox TB_ServerUpass;
        private System.Windows.Forms.TextBox TB_ServerUname;
        private System.Windows.Forms.TextBox TB_DataName;
        private System.Windows.Forms.TextBox TB_ServerPort;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Label LB_ServerConnected;
        private System.Windows.Forms.Button Btn_Copy_Input;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newFileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem restartToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.CheckBox checkBox2;
        private System.Windows.Forms.CheckBox checkBox3;
    }
}