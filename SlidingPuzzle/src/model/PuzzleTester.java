package model;

public class PuzzleTester
{

    public static void main( String[] args )
    {
        Puzzle puzzle = new Puzzle( 4 );
        puzzle.move( 12 );
        puzzle.move( 11 );
        puzzle.move( 15 );
        puzzle.move( 14 );
        puzzle.move( 10 );
        puzzle.move( 9 );
        puzzle.move( 5 );
        puzzle.displayPuzzle();
        System.out.println( "===========================" );
        System.out.println( puzzle.BFS() );

    }

}
