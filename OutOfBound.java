package com.company;

/**
 * @author Luyet Thomas
 * <p>Cette classe va permettre de personnaliser l'exception OutOfBounds
 * </p>
 */

public class OutOfBound extends ArrayIndexOutOfBoundsException {

public OutOfBound(String message){

    super(message);

}

}
