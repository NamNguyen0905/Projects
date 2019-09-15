public class KnightMoves{

  static int ith_num = 1;
  static int[] subarray = new int[3];

  public static void main(String[] args){
    System.out.println("Input size of matrix: ");
    int size = IO.readInt();
    int[][] array = new int[size][size];

    System.out.println("Input i_position of the knight: ");
    int i_pos = IO.readInt();
    System.out.println("Input j_position of the knight: ");
    int j_pos = IO.readInt();
    array[i_pos-1][j_pos-1] = 1;
    subarray[0] = 1;

   if(perfectMoves(array,subarray, i_pos-1,j_pos-1) == true){
    printArray(array);
   } else{ 
    System.out.println("No solution");
   }
}

  public static void printArray (int[][] array){
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array.length; j++){
        System.out.print(array[i][j]+ " ");
      }
      System.out.println();
   }
  }

  //static long count = 0;
  //static int[][] newArray; 
  // (int) Math.pow(8,(int) Math.pow(arr.length,2))

  public static boolean perfectMoves(int[][] arr, int[] sub, int i_pos,int j_pos){
    if(sub[0] == (int) Math.pow(arr.length,2)){
      /*if (count < (int) Math.pow(8,(int) Math.pow(arr.length,2))){
        if (arr != newArray){
          printArray(arr);
          System.out.print(count + "\n");
        }
        newArray = arr; 
        return false;
      } else{*/
        return true;
      //}
    }

    else{
      for (int i = 1; i <= 8; i++){
        //count ++;
        if (move(arr,sub,i_pos,j_pos,i, sub[0]) == true){
          if(perfectMoves(arr,sub,sub[1],sub[2]) == true){
            return true;
          } else{
            arr[get_i_pos_of_current_position(arr,sub[0])][get_j_pos_of_current_position(arr,sub[0])] = 0;
            sub[0] --; 
          }
        }
      }
      return false;
    }
  }


  public static boolean move(int[][] arr, int[] sub, int i_pos,int j_pos, int dir, int ith_num){
    switch (dir){
      case 1:
              if(i_pos-2 >=0 && j_pos+1 < arr.length){
                if(arr[i_pos-2][j_pos+1] == 0){
                  arr[i_pos-2][j_pos+1] = ith_num+1;
                  sub[0] = ith_num+1;
                  sub[1] = i_pos-2;
                  sub[2] = j_pos+1;
                  return true;   //
                }
              }
              return false;
      case 2:
              if(i_pos-1 >=0 && j_pos+2 < arr.length){
                if(arr[i_pos-1][j_pos+2] == 0){
                  arr[i_pos-1][j_pos+2] = ith_num+1;
                  sub[0] = ith_num+1;
                  sub[1] = i_pos-1;
                  sub[2] = j_pos+2;
                  return true;
                }
              }
              return false;
      case 3:
              if(i_pos+1 <arr.length && j_pos+2 < arr.length){
                if(arr [i_pos+1][j_pos+2] == 0){
                  arr[i_pos+1][j_pos+2] = ith_num+1;
                  sub[0] = ith_num+1;
                  sub[1] = i_pos+1;
                  sub[2] = j_pos+2;
                  return true;
                }
              }
              return false;
      case 4:
              if(i_pos+2 < arr.length && j_pos+1 < arr.length){
                if(arr [i_pos+2][j_pos+1] == 0){
                  arr[i_pos+2][j_pos+1] = ith_num+1;
                  sub[0] = ith_num+1;
                  sub[1] = i_pos+2;
                  sub[2] = j_pos+1;
                  return true;
                }
              }
              return false;
      case 5:
             if(i_pos+2 < arr.length && j_pos-1 >=0){
              if(arr[i_pos+2][j_pos-1] == 0){
                arr[i_pos+2][j_pos-1] = ith_num+1;
                sub[0] = ith_num+1;
                sub[1] = i_pos+2;
                sub[2] = j_pos-1;
                return true;
              }
            }
            return false;
      case 6:
             if(i_pos+1 <arr.length && j_pos-2 >= 0){
               if(arr[i_pos+1][j_pos-2] == 0){
                 arr[i_pos+1][j_pos-2] = ith_num+1;
                 sub[0] = ith_num+1;
                 sub[1] = i_pos+1;
                 sub[2] = j_pos-2;
                 return true;
               }
             }
             return false;
      case 7:
             if(i_pos-1 >=0 && j_pos-2 >= 0){
               if(arr[i_pos-1][j_pos-2] == 0){
                 arr[i_pos-1][j_pos-2] = ith_num+1;
                 sub[0] = ith_num+1;
                 sub[1] = i_pos-1;
                 sub[2] = j_pos-2;
                 return true;
               }
             }
             return false;
      case 8:
             if(i_pos-2 >=0 && j_pos-1 >=0){
               if(arr[i_pos-2][j_pos-1] == 0){
                 arr[i_pos-2][j_pos-1] = ith_num+1;
                 sub[0] = ith_num+1;
                 sub[1] = i_pos-2;
                 sub[2] = j_pos-1;
                 return true;
               }
             }
             return false;
      default: return false;
    }
  }

  public static int get_i_pos_of_current_position(int[][] arr,int ith_num){
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr.length; j++){
        if (arr[i][j] == ith_num){
          return i;
        }
      }
    }
    return -1;
  }

  public static int get_j_pos_of_current_position(int[][] arr,int ith_num){
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr.length; j++){
        if (arr[i][j] == ith_num){
          return j;
        }
      }
    }
    return -1;
  }

}
