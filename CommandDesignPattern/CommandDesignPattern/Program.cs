﻿using System;

namespace CommandDesignPattern
{
    class Program
    {
        public static void Main(string[] args)
        {
            Document document = new Document();
            ICommand openCommand = new OpenCommand(document);
            ICommand saveCommand = new SaveCommand(document);
            ICommand closeCommand = new CloseCommand(document);

            MenuOptions menu = new MenuOptions(openCommand, saveCommand, closeCommand);

            menu.clickOpen();
            menu.clickSave();
            menu.clickClose();

            Console.ReadKey();
        }
    }
}
