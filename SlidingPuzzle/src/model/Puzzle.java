package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Puzzle
{
    private int dimension;
    private ArrayList<ArrayList<Integer>> board;
    private ArrayList<Integer> path;
    private int lastMove;


    public Puzzle( int dimension )
    {
        this.dimension = dimension;
        initializePuzzle( dimension );
    }


    private void initializePuzzle( int dimension )
    {
        board = new ArrayList<>();
        for( int i = 0; i < dimension; i++ )
        {
            ArrayList<Integer> iRow = new ArrayList<Integer>();
            for( int j = 0; j < dimension; j++ )
            {
                if( i == dimension - 1 && j == dimension - 1 )
                {
                    iRow.add( j, 0 );
                }
                else
                {
                    iRow.add( j, (i * dimension) + j + 1 );
                }
            }
            board.add( i, iRow );
        }
        path = new ArrayList<Integer>();

    }


    public ArrayList<Integer> getBlankSpacePosition()
    {

        ArrayList<Integer> position = new ArrayList<Integer>();
        for( int i = 0; i < dimension; i++ )
        {
            for( int j = 0; j < dimension; j++ )
            {
                if( board.get( i ).get( j ) == 0 )
                {
                    position.add( i );
                    position.add( j );
                }
            }
        }
        return position;
    }


    public void swap( int x1, int y1, int x2, int y2 )
    {
        int tmp = board.get( x1 ).get( y1 );
        board.get( x1 ).set( y1, board.get( x2 ).get( y2 ) );
        board.get( x2 ).set( y2, tmp );
    }


    private enum Direction
    {
        LEFT, RIGHT, DOWN, UP, INVALID;
    }


    public Direction getMove( int piece )
    {
        List<Integer> blankSpacePosition = getBlankSpacePosition();
        int line = blankSpacePosition.get( 0 );
        int column = blankSpacePosition.get( 1 );
        if( line > 0 && piece == board.get( line - 1 ).get( column ) )
        {
            return Direction.DOWN;
        }
        else if( line < this.dimension - 1 && piece == board.get( line + 1 ).get( column ) )
        {
            return Direction.UP;
        }
        else if( column > 0 && piece == board.get( line ).get( column - 1 ) )
        {
            return Direction.RIGHT;
        }
        else if( column < this.dimension - 1 && piece == board.get( line ).get( column + 1 ) )
        {
            return Direction.LEFT;
        }
        return Direction.INVALID;
    }


    public Direction move( int piece )
    {
        Direction move = getMove( piece );
        ArrayList<Integer> blankSpacePosition = getBlankSpacePosition();
        int line = blankSpacePosition.get( 0 );
        int column = blankSpacePosition.get( 1 );
        switch( move )
        {
            case LEFT:
                swap( line, column, line, column + 1 );
                break;
            case RIGHT:
                swap( line, column, line, column - 1 );
                break;
            case DOWN:
                swap( line, column, line - 1, column );
                break;
            case UP:
                swap( line, column, line + 1, column );
                break;
            default:
                break;
        }
        this.lastMove = piece;
        return move;
    }


    public void displayPuzzle()
    {
        for( int i = 0; i < dimension; i++ )
        {
            for( int j = 0; j < dimension; j++ )
            {
                System.out.print( board.get( i ).get( j ) + "  " );
            }
            System.out.println();
        }
    }


    public boolean isFinalState()
    {
        for( int i = 0; i < this.dimension; i++ )
        {
            for( int j = 0; j < this.dimension; j++ )
            {
                int piece = board.get( i ).get( j );
                if( piece != 0 )
                {
                    int originalLine = ((piece - 1) / this.dimension);
                    int originalColumn = (piece - 1) % this.dimension;
                    if( i != originalLine || j != originalColumn )
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public List<Integer> getMovablePieces()
    {
        List<Integer> allowedMoves = new ArrayList<Integer>();
        for( int i = 0; i < this.dimension; i++ )
        {
            for( int j = 0; j < dimension; j++ )
            {
                int piece = board.get( i ).get( j );
                if( getMove( piece ) != Direction.INVALID )
                {
                    allowedMoves.add( piece );
                }
            }
        }
        return allowedMoves;
    }


    public ArrayList<ArrayList<Integer>> getBoard()
    {
        return this.board;
    }


    public ArrayList<Integer> getPath()
    {
        return this.path;
    }


    public Puzzle getCopy()
    {
        Puzzle copy = new Puzzle( this.dimension );
        for( int i = 0; i < dimension; i++ )
        {
            for( int j = 0; j < dimension; j++ )
            {
                copy.getBoard().get( i ).set( j, this.board.get( i ).get( j ) );
            }
        }
        for( int i = 0; i < this.path.size(); i++ )
        {
            copy.getPath().add( i, path.get( i ) );
        }

        return copy;
    }

    public ArrayList<Puzzle> visit(){
            ArrayList<Puzzle> children = new ArrayList<Puzzle>();
            List<Integer> movablePieces = this.getMovablePieces();
            for (int i = 0; i < movablePieces.size(); i++)  {
                int movablePiece= movablePieces.get( i );
                if (movablePiece != this.lastMove) {
                    Puzzle newInstance = this.getCopy();
                    newInstance.move(movablePiece);
                    newInstance.getPath().add(movablePiece);
                    children.add(newInstance);
                }
            }
            return children;
    }
    
    public ArrayList<Integer> BFS(){
        Puzzle startingState = this.getCopy();
        startingState.setPath(new ArrayList<Integer>());
        Queue<Puzzle> states = new LinkedList<Puzzle>();
        states.add( startingState );
        while (states.size() > 0) {
            Puzzle state = states.remove();
            if (state.isFinalState()) {
                return state.getPath();
            }
            states.addAll(state.visit());
        }
        return null;
    }


    private void setPath( ArrayList<Integer> arrayList )
    {
       this.path = arrayList;
        
    }
}
