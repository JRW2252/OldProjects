package copyofarraytest;

/**
 *
 * @author jameswilliams
 */
public class CopyOfArrayTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        double [] oldprod = new double [20];
        oldprod[0] = 1;
        oldprod[1] = 3;
        oldprod[2] = 5;
        oldprod[3] = 7;
        oldprod[4] = 9;
        oldprod[5] = 11;
        oldprod[6] = 13;
        oldprod[7] = 15;
        oldprod[8] = 17;
        oldprod[9] = 19;
        oldprod[10] = 21;
        oldprod[11] = 23;
        oldprod[12] = 25;
        oldprod[13] = 27;
        oldprod[14] = 29;
        oldprod[15] = 31;
        oldprod[16] = 33;
        oldprod[17] = 35;
        oldprod[18] = 37;
        oldprod[19] = 39;
        
        System.out.println("value ");
    
    /*for(int i = 0; i < oldprod.length; i++)
    {
        System.out.println(i + "\toldprod\t\t" + oldprod[i]);
    }*/
    //CREATE NEW PROD AND LENGTH
    double [] newprod = new double [40];
    for(int i = 0; i < oldprod.length; i ++)
    {
        //MULTIPLY NEWPROD[I*2] TO SPACE THE COPIED VALUES
        newprod[i*2] = oldprod[i];
    }
    oldprod = newprod;
    
    //REGULAR PRINT OF i + newprod + COPIED VALUE
    //ASSIGNED i = 1 BC I DID NOT WANT TO START W/0.
    for(int i = 1; i < newprod.length; i ++)
    {
        //PRINT NEWPROD AND VALUES
        System.out.println(i + "\tnewprod\t\t" + newprod[i]);
    }
    }
    
}
