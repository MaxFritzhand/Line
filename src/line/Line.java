/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package line;
 
/**
 *
 * @author MaxFritzhand
 */
public class Line {

    
    private double theSlope;
    private double theYInt;
    private boolean undefinedSlope;
     
    public Line(double x, double y, double slope)
    {
        theSlope = slope;
        theYInt = (-slope * x) + y;
    }
    public Line(double x1, double y1, double x2, double y2)
    {   
        if(x2-x1 == 0)
        {
            undefinedSlope = true;
            theYInt = Double.POSITIVE_INFINITY;  // Double.POSITIVE_INFINITY makes it so that its equal to returned value (0)
        }
        else
        {
            theSlope = (y2-y1)/(x2-x1);
            theYInt = (-(y2-y1)/(x2-x1) * x1) + y1;
        }
    }
    public Line(double m, double yInt)
    {
        theSlope = m;
        theYInt = yInt;
    }
    public Line(double a)
    {
        undefinedSlope = true;
        theYInt = Double.POSITIVE_INFINITY;
    }
    public boolean isParallel(Line other)        
    {
            // if the lines have the same slope, but they don't share a point, they are parallel
    
        boolean parallel = false;
         
        if((theSlope == other.theSlope && undefinedSlope == false) || (undefinedSlope == true && other.undefinedSlope == true))     
        {
            parallel = true;
        }
        return parallel;
    }
    public boolean equals(Line other)    
    {
            // if the lines have the same slope and share a point, they are equal
        boolean equal = false;
         
        if(isParallel(other) && theYInt == other.theYInt)
        {
            equal = true;
        }
        return equal;
    }
    public boolean intersects(Line other)   
    {
            // if the lines aren't equal, and they aren't parallel, they intersect
    
        boolean intersect = false;
         
        if(!isParallel(other) || equals(other))
        {
            intersect = true;
        }
        return intersect;




    }
    
}
