package com.parkinglot.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class ParkingLotCLI
{
    static CLICommandParser commandParser = new CLICommandParser();


    public static void main( String[] args )
    {

        if( args.length == 1 && ".txt".equals( args[0].substring( args[0].lastIndexOf( "." ) ) ) )
        {

            processFileInput( args[0] );
            return;
        }
        else if( args.length == 0 )
        {

            processInteractiveCommands();
        }
        else
        {

            System.out
                .println( "Illegal arguments provided. Please see option -help for more details" );
        }

    }


    public static void processInteractiveCommands()
    {
        while( true )
        {

            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
            String line;
            try
            {
                line = reader.readLine();
                if( "exit".equals( line ) )
                {
                    return;
                }
                processASingleCommand( line );
            }
            catch( IOException e )
            {
                System.out.println( "exception during reading command. Please try again" );
            }

        }

    }


    public static void processFileInput( String string )
    {

        try( Stream<String> stream = Files.lines( Paths.get( string ) ))
        {

            stream.forEach( t -> processASingleCommand( t ) );

        }
        catch( IOException e )
        {
            System.out.println( "Error during reading file. Please try again" );
        }

    }


    public static void processASingleCommand( String command )
    {
        commandParser.parse( command );
    }
}
