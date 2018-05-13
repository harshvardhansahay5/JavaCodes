/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convex_hull;
import java.util.*;

/**
 *
 * @author Sahay
 */
public class collection_of_points {
    private int number_of_pts;//stores the total number of points
    Scanner sc = new Scanner(System.in);
    //global matrix to store coordinates
    //first row contains x coordinates
    //second row contains y coordinates
    //third row contains distance from global_centroid(mean x, mean y)
    private double points[][];
    private double meanx, meany;//global_centroid
    private double tempmeanx = 0, tempmeany = 0;//temporary centroid(changes after addition of every vertex to linked list vertices
    private boolean global_centroid_status = false;//tells whether global_centroid(meanx, meany) has been engulfed by the polygon or not
    private final LinkedList<Integer> vertices = new LinkedList<>();//linked list to store the vertices of the polygon

    void getpts() 
    {//function for getting input(points) from user and sorting them
        System.out.println("Enter the number of Points: ");
        
        do {//!!!number of points shouldn't be less than 3            
            number_of_pts = sc.nextInt();
        } while(number_of_pts < 3);//end of do...while loop
        
        points = new double[3][number_of_pts];//initializing storace of points

        for(int i = 1; i <= number_of_pts; i++) {//getting user input
            System.out.println("Enter x coordinate of point number" + i + ": ");
            points[0][i - 1] = sc.nextDouble();
            System.out.println(points[0][i-1]);
            System.out.println("Enter y coordinate of point number" + i + ": ");
            points[1][i - 1] = sc.nextDouble();
            System.out.println(points[1][i-1]);
        }
        
        //calculating (meanx, meany) aka global centroid
        meanx = sum(points[0]) / number_of_pts;
        meany = sum(points[1]) / number_of_pts;
        //calculating distances all points from global centroid
        //and inserting it in third row of points i.e points[2]
        for(int i = 1; i <= number_of_pts; i++) {
            points[2][i - 1] = distance_between_pts(meanx, meany, points[0][i-1], points[1][i-1]);
        }
        
        //sorting points according to distance of points from centroid
        sort(points, 0, number_of_pts - 1);
        boundary_pts();
        putvertices();
    }
    
    private double sum(double...values) {//calculates the sum of all elements in a linear array
        double result = 0;
        for(double value:values)
            result += value;
        return result;
    }
    
    //quicksort body begins
    private int partition(double arr[][], int low, int high) {
        double pivot = arr[2][high]; 
        int i = (low - 1); // index of higher element
        for (int j = low; j < high; j++) {
            // If current element is higher than or
            // equal to pivot
            if (arr[2][j] >= pivot) {
                i++;
 
                // swap arr[i] and arr[j]
                for(int x = 0; x < 3; ++x) {
                    double temp = arr[x][i];
                    arr[x][i] = arr[x][j];
                    arr[x][j] = temp;
                }
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        for(int x = 0; x < 3; ++x) {
            double temp = arr[x][i + 1];
            arr[x][i + 1] = arr[x][high];
            arr[x][high] = temp;
        }
        return i + 1;
    }
 
 
    /* The primary function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void sort(double arr[][], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    //quicksort body ends
    
    private double[] line_eqn_generator(double x1, double y1, double x2, double y2) {//generates the values of a, b and c(ax+by+c=0) and returns an array with the values of a, b and c
        double abc[] = new double[3];
        double m = y2 - y1 / x2 - x1;
        double c = y1 - m * x1;
        abc[0] = m;//a
        abc[1] = -1;//b
        abc[2] = c;//c
        return abc;
    }
    
    private double whichside(double parame[], double...coordinates) {//parame[] contains value of a, b and c of a line(ax+by+c=0), coordinates contain(x, y) of the point and returns distance(with sign) between a line and a point
        return Math.signum(parame[0] * coordinates[0] + parame[1] * coordinates[1] + parame[2]);
    }
    
    private boolean check_inside(double...coordinates) {//checks whether a point is inside the polygon or not
        int i;
        double distcentroid, distpt;//distance(with sign) of temp_centroid(tempmeanx, temp meany) and the point from that line
        for (i = 0; i < vertices.size() - 1; ++i) {
            distcentroid = whichside(line_eqn_generator(points[0][vertices.get(i)], points[1][vertices.get(i)], points[0][vertices.get(i) + 1], points[1][vertices.get(i) + 1]), tempmeanx, tempmeany);
            distpt = whichside(line_eqn_generator(points[0][vertices.get(i)], points[1][vertices.get(i)], points[0][vertices.get(i) + 1], points[1][vertices.get(i) + 1]), coordinates);
            if ((distcentroid * distpt) < 0)//returns false(not inside) if the sign of 
                return false;
        }
        distcentroid = whichside(line_eqn_generator(points[0][vertices.get(i)], points[1][vertices.get(i)], points[0][vertices.getFirst()], points[1][vertices.getFirst()]), tempmeanx, tempmeany);
        distpt = whichside(line_eqn_generator(points[0][vertices.get(i)], points[1][vertices.get(i)], points[0][vertices.getFirst()], points[1][vertices.getFirst()]), coordinates);
        if ((distcentroid * distpt) < 0)//returns false(not inside) if the sign of 
                return false;           //redundant if() just for checking with the last side of the polygon because last side would be made by first and last point of the vertices linked list
        return true;//if everythings good(point inside the polygon) then returns true
    }
    
    private void add_and_updatecentroid(int...index) {//takes the index(at which point has to be stored in vertices) or/and index of point in points and adds points to vertices
        //updating tempmeanx and tempmeany and adding vertex to the linked list vertices
        if(index.length == 1) {//index.length == 1 when vertex is to be added at theend of the linked list vertices
            tempmeanx = (tempmeanx * vertices.size() + points[0][index[0]]) / (vertices.size() + 1);
            tempmeany = (tempmeany * vertices.size() + points[1][index[0]]) / (vertices.size() + 1);
            vertices.add(index[0]);
        } 
        else {
            tempmeanx = (tempmeanx * vertices.size() + points[0][index[1]]) / (vertices.size() + 1);
            tempmeany = (tempmeany * vertices.size() + points[1][index[1]]) / (vertices.size() + 1);
            vertices.add(index[0], index[1]);
        }
        if (!global_centroid_status) {//will check each time whether global_centroid(meanx, meany) is inside the polygon formed or not
                                      //won't be checked once global_centroid_status toggles to true
            if(check_inside(meanx, meany))
                global_centroid_status = !global_centroid_status;
        }
    }
    
    private double distance_between_pts(double...coordinates) {//function to calculate the distance between two points
        return Math.sqrt(Math.pow(coordinates[0] - coordinates[2], 2) + Math.pow(coordinates[1] - coordinates[3], 2));
    }
    
    private void boundary_pts() {//for calculating the points that will be a boundary point(vertex)
        double distpt;//for storing temporary sum of length of possible new sides
        int index_of_shortestperi;//for keeping record where the vertex should be added in the linked list
        int vertice;
        add_and_updatecentroid(0);//added
        add_and_updatecentroid(1);//by
        add_and_updatecentroid(2);//default
        for(int i = 3; i < points.length; ++i) {//loop for traversing (sorted) points matrix
            if(check_inside(points[0][i], points[1][i])) {//checking whether point is already inside
                if (global_centroid_status) {//checking whether global_centroid(meanx, meany) is also inside
                    break;//breaking if both are inside
                }
                continue;//continuing if point is inside and global_centroid(meanx, meany) is outside
            }
            distpt = Double.MAX_VALUE;//arbitrary assignment of value to distpt
            index_of_shortestperi = Integer.MIN_VALUE;//arbitrary assignment of value to index_of _shortestperi
            for (vertice = 0; vertice < vertices.size() - 1; ++vertice) {//traversing through linked list vertices and checking
                if(distance_between_pts(points[0][i], points[1][i], points[0][vertices.get(vertice)], points[1][vertices.get(vertice)]) + distance_between_pts(points[0][i], points[1][i], points[0][vertices.get(vertice + 1)], points[1][vertices.get(vertice + 1)]) < distpt) {//looking for shortest distance
                    distpt = distance_between_pts(points[0][i], points[1][i], points[0][vertices.get(vertice)], points[1][vertices.get(vertice)]) + distance_between_pts(points[0][i], points[1][i], points[0][vertices.get(vertice + 1)], points[1][vertices.get(vertice + 1)]);//updating distpt if distance is found shorter than the previous
                    index_of_shortestperi = vertice + 1;//updating index
                }
            }
            if(distance_between_pts(points[0][i], points[1][i], points[0][vertices.get(vertice)], points[1][vertices.get(vertice)]) + distance_between_pts(points[0][i], points[1][i], points[0][vertices.getFirst()], points[1][vertices.getFirst()]) < distpt) {//redundant if() just for checking with the last side of the polygon because last side would be made by first and last point of the vertices linked list
                    index_of_shortestperi = -1;
            }
            if (index_of_shortestperi == -1)//add to end of linked list
                add_and_updatecentroid(i);
            else add_and_updatecentroid(index_of_shortestperi, i);//add to suitable position
        }
    }

    private void putvertices() {//displaying the vertices of the required convex polygon
        System.out.println("Vertices of the required convex polygon:");
        for (int vertice = 0; vertice < vertices.size(); ++vertice) {//traversing through linked list vertices and displaying
                System.out.println(points[0][vertices.get(vertice)] + ", " + points[1][vertices.get(vertice)]);
            }
    }
    
}