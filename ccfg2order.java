
/**
 * Write a description of ccfg2order here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import mosek.*;

public class ccfg2order
{
  static final int numcon = 44;
  static final int numvar = 67;
  static final int NUMANZ = 9;
       
  public static void main (String[] args)
  {
    // Since the value infinity is never used, we define
    // 'infinity' symbolic purposes only
    double
      infinity = 0;
    
    double c[]    = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    int    asub[][] = { {27,28,29,30},
                        {31,32,33,34},
                        {35,36,37,38},
                        {39,40,41,42},
                        {43,44,45,46},
                        {47,48,49,50},
                        {51,52,53,54},
                        {55,56,57,58},
                        {59,60,61,62},
                        {63,64,65,66},
                        {27,31,35,39,43,47,51,55,59,63},
                        {28,32,36,40,44,48,52,56,60,64},
                        {29,33,37,41,45,49,53,57,61,65},
                        {30,34,38,42,46,50,54,58,62,66},
                        {0,28},
                        {1,27,28,29},
                        {2,28,29,30},
                        {0,3,32},
                        {1,4,31,32,33},
                        {2,5,32,33,34},
                        {3,6,36},
                        {4,7,35,36,37},
                        {5,8,36,37,38},
                        {6,9,40},
                        {7,10,39,40,41},
                        {8,11,40,41,42},
                        {9,12,44},
                        {10,13,43,44,45},
                        {11,14,44,45,46},
                        {12,15,48},
                        {13,16,47,48,49},
                        {14,17,48,49,50},
                        {15,18,52},
                        {16,19,51,52,53},
                        {17,20,52,53,54},
                        {18,21,56},
                        {19,22,55,56,57},
                        {20,23,56,57,58},
                        {21,24,60},
                        {22,25,59,60,61},
                        {23,26,60,61,62},
                        {24,64},
                        {25,63,64,65},
                        {26,64,65,66}};
    double aval[][] = { {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
                        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
                        {-1.0, -1.0},
                        {-1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {-1.0, 1.0, 1.0, 1.0, -1.0},
                        {1.0, -1.0},
                        {1.0, 1.0, 1.0, -1.0},
                        {1.0, 1.0, 1.0, -1.0}};
    mosek.boundkey[]
                 bkc    = {mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx,
                           mosek.boundkey.fx};
    
    double  blc[]  = {1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      -1.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0};
    
    double  buc[]  = {1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      -1.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0};
    mosek.boundkey
            bkx[]  = {mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.lo,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra,
                      mosek.boundkey.ra};
    double  blx[]  = {0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0,
                      0.0};
    double  bux[]  = {+infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      +infinity,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0,
                      1.0};
    double[] xx  = new double[numvar];

    try (Env  env  = new Env(); 
         Task task = new Task(env,0,0))
    {
      // Directs the log task stream to the user specified
      // method task_msg_obj.stream
      task.set_Stream(
        mosek.streamtype.log,
        new mosek.Stream() 
          { public void stream(String msg) { System.out.print(msg); }});

      /* Give MOSEK an estimate of the size of the input data. 
     This is done to increase the speed of inputting data. 
     However, it is optional. */
      /* Append 'numcon' empty constraints.
     The constraints will initially have no bounds. */
      task.appendcons(numcon);
      
      /* Append 'numvar' variables.
     The variables will initially be fixed at zero (x=0). */
      task.appendvars(numvar);
        
      for(int j=0; j<numvar; ++j)
      {
        /* Set the linear term c_j in the objective.*/  
        task.putcj(j,c[j]);
        /* Set the bounds on variable j.
           blx[j] <= x_j <= bux[j] */
        task.putbound(mosek.accmode.var,j,bkx[j],blx[j],bux[j]);
      }
      /* Set the bounds on constraints.
       for i=1, ...,numcon : blc[i] <= constraint i <= buc[i] */
      for(int i=0; i<numcon; ++i)
      {  
        task.putbound(mosek.accmode.con,i,bkc[i],blc[i],buc[i]);

          /* Input row i of A */   
          task.putarow(i,                     /* Row index.*/
                       asub[i],               /* Column indexes of non-zeros in row i.*/
                       aval[i]);              /* Non-zero Values of row i. */
      }

      /* A maximization problem */ 
      task.putobjsense(mosek.objsense.maximize);

      /* Solve the problem */
      mosek.rescode r = task.optimize();
                
      // Print a summary containing information
      //   about the solution for debugging purposes
      task.solutionsummary(mosek.streamtype.msg);     
       
      mosek.solsta solsta[] = new mosek.solsta[1];
      /* Get status information about the solution */ 
      task.getsolsta(mosek.soltype.bas,solsta);

      task.getxx(mosek.soltype.bas, // Basic solution.     
                 xx);
      switch(solsta[0])
      {
      case optimal:
      case near_optimal:
        System.out.println("Optimal primal solution\n");
        for(int j = 0; j < numvar; ++j)
          System.out.println ("x[" + j + "]:" + xx[j]);
        break;
      case dual_infeas_cer:
      case prim_infeas_cer:
      case near_dual_infeas_cer:
      case near_prim_infeas_cer:  
        System.out.println("Primal or dual infeasibility.\n");
        break;
      case unknown:
        System.out.println("Unknown solution status.\n");
        break;
      default:
        System.out.println("Other solution status");
        break;
      }
    }
    catch (mosek.Exception e)
    {
      System.out.println ("An error/warning was encountered");
      System.out.println (e.toString());
      throw e;
    }
  }
}