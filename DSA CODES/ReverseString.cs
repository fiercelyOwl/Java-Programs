using System;

class Program
{
    static void ReversePrint()
    {
        int ch = Console.Read();
        if (ch != '\n' && ch != -1)
        {
            ReversePrint();
            Console.Write((char)ch);
        }
    }

    static void Main(string[] args)
    {
        Console.Write("Enter a line of text: ");
        ReversePrint();
        Console.WriteLine();
    }
}
