/** 
 * This skeleton is just an exmple.
 * Feel free to change this skeleton or using better ideas to implement.  
 */

import java.util.*;

// implement the class of block if necessary
class Block {
    public int type = 0;
    public int[]coordinate;//top left corner of block
    
    public Block(int type, int[]coordinate) {
        this.type = type;
        this.coordinate = coordinate;
    }
    
    public ArrayList<GameState>checkMovablePositions(int[][]board, GameState currentState){
        ArrayList<GameState>movablePositions = new ArrayList<GameState>();

        if(this.type == 4) {//1x1, only need to check empty blocks
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    int[][]movedBoard = new int[5][4];
                    for (int k = 0; k < 5; k++) {//make copy of array
                        for (int l = 0; l < 4; l++) {
                            movedBoard[k][l] = board[k][l];
                        }
                    }
                    if(board[i][j] == 0) {
                        movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;//set original spot to empty
                        movedBoard[i][j] = 4;//set new spot to 1x1
                        GameState newState = new GameState(movedBoard, currentState);
                        movablePositions.add(newState);
                    }
                }
            }
            return movablePositions;//no need to check others
        }
        
        if(checkUp(board)) {//check move up
            int[][]movedBoard = new int[5][4];
            for (int k = 0; k < 5; k++) {//make copy of array
                for (int l = 0; l < 4; l++) {
                    movedBoard[k][l] = board[k][l];
                }
            }
            if(this.type == 1) {//2x2 move up
                movedBoard[this.coordinate[0] - 1][this.coordinate[1]] = 1;
                movedBoard[this.coordinate[0] - 1][this.coordinate[1] + 1] = 1;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1] + 1] = 0;
            }
            if(this.type == 2) {//2x1 move up
                movedBoard[this.coordinate[0] - 1][this.coordinate[1]] = 2;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1]] = 0;
            }
            if(this.type == 3) {//1x2 move up
                movedBoard[this.coordinate[0] - 1][this.coordinate[1]] = 3;
                movedBoard[this.coordinate[0] - 1][this.coordinate[1] + 1] = 3;
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] + 1] = 0;
            }
            GameState newState = new GameState(movedBoard, currentState);
            movablePositions.add(newState);
        }

        if(checkDown(board)) {//check move down
            int[][]movedBoard = new int[5][4];
            for (int k = 0; k < 5; k++) {//make copy of array
                for (int l = 0; l < 4; l++) {
                    movedBoard[k][l] = board[k][l];
                }
            }
            if(this.type == 1) {//2x2 move down
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] + 1] = 0;
                movedBoard[this.coordinate[0] + 2][this.coordinate[1]] = 1;
                movedBoard[this.coordinate[0] + 2][this.coordinate[1] + 1] = 1;
            }
            if(this.type == 2) {//2x1 move down
                movedBoard[this.coordinate[0] + 2][this.coordinate[1]] = 2;
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
            }
            if(this.type == 3) {//1x2 move down
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] + 1] = 0;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1]] = 3;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1] + 1] = 3;
            }
            GameState newState = new GameState(movedBoard, currentState);
            movablePositions.add(newState);
        }
        
        if(checkRight(board)) {//check move right
            int[][]movedBoard = new int[5][4];
            for (int k = 0; k < 5; k++) {//make copy of array
                for (int l = 0; l < 4; l++) {
                    movedBoard[k][l] = board[k][l];
                }
            }
            if(this.type == 1) {//2x2 move right
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] + 2] = 1;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1] + 2] = 1;
            }
            if(this.type == 2) {//2x1 move right
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] + 1] = 2;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1] + 1] = 2;
            }
            if(this.type == 3) {//1x2 move right
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] + 2] = 3;
            }
            GameState newState = new GameState(movedBoard, currentState);
            movablePositions.add(newState);
        }

        if(checkLeft(board)) {//check move left
            int[][]movedBoard = new int[5][4];
            for (int k = 0; k < 5; k++) {//make copy of array
                for (int l = 0; l < 4; l++) {
                    movedBoard[k][l] = board[k][l];
                }
            }
            if(this.type == 1) {//2x2 move left
                movedBoard[this.coordinate[0]][this.coordinate[1] + 1] = 0;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1] + 1] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] - 1] = 1;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1] - 1] = 1;
            }
            if(this.type == 2) {//2x1 move left
                movedBoard[this.coordinate[0]][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1]] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] - 1] = 2;
                movedBoard[this.coordinate[0] + 1][this.coordinate[1] - 1] = 2;
            }
            if(this.type == 3) {//1x2 move left
                movedBoard[this.coordinate[0]][this.coordinate[1] + 1] = 0;
                movedBoard[this.coordinate[0]][this.coordinate[1] - 1] = 3;
            }
            GameState newState = new GameState(movedBoard, currentState);
            movablePositions.add(newState);
        }
        return movablePositions;
    }
    
    public boolean checkUp(int[][]board) {
        try{
            if(this.type == 1) {//check coordinate up and right->up
                if(board[this.coordinate[0] - 1][this.coordinate[1]] == 0
                    &&board[this.coordinate[0] - 1][this.coordinate[1] + 1] == 0) {
                    return true;
                }
            }
            if(this.type == 2) {//check coordinate above
                if(board[this.coordinate[0] - 1][this.coordinate[1]] == 0) {
                    return true;
                }
            }
            if(this.type == 3) {//check coordinate up and right->up
                if(board[this.coordinate[0] - 1][this.coordinate[1]] == 0
                    &&board[this.coordinate[0] - 1][this.coordinate[1] + 1] == 0) {
                    return true;
                }
            }
        }
        catch(Exception e) {
            return false;
        }
        return false;
    }
    
    public boolean checkDown(int[][]board) {
        try{
            if(this.type == 1) {//check coordinate down and right->down
                if(board[this.coordinate[0] + 2][this.coordinate[1]] == 0
                    &&board[this.coordinate[0] + 2][this.coordinate[1] + 1] == 0) {
                    return true;
                }
            }
            if(this.type == 2) {//check coordinate below
                if(board[this.coordinate[0] + 2][this.coordinate[1]] == 0) {
                    return true;
                }
            }
            if(this.type == 3) {//check coordinate down and right->down
                if(board[this.coordinate[0] + 1][this.coordinate[1]] == 0
                    &&board[this.coordinate[0] + 1][this.coordinate[1] + 1] == 0) {
                    return true;
                }
            }
        }
        catch(Exception e) {
            return false;
        }
        return false;
    }
    
    public boolean checkRight(int[][]board) {
        try{
            if(this.type == 1) {//check coordinate right and right->down
                if(board[this.coordinate[0]][this.coordinate[1] + 2] == 0
                    &&board[this.coordinate[0] + 1][this.coordinate[1] + 2] == 0) {
                    return true;
                }
            }
            if(this.type == 2) {//check coordinate right and right->down
                if(board[this.coordinate[0]][this.coordinate[1] + 1] == 0
                    &&board[this.coordinate[0] + 1][this.coordinate[1] + 1] == 0) {
                    return true;
                }
            }
            if(this.type == 3) {//check coordinate right
                if(board[this.coordinate[0]][this.coordinate[1] + 2] == 0) {
                    return true;
                }
            }
        }
        catch(Exception e) {
            return false;
        }
        return false;
    }
    
    public boolean checkLeft(int[][]board) {
        try{
            if(this.type == 1) {//check coordinate left and left->down
                if(board[this.coordinate[0]][this.coordinate[1] - 1] == 0
                    &&board[this.coordinate[0] + 1][this.coordinate[1] - 1] == 0) {
                    return true;
                }
            }
            if(this.type == 2) {//check coordinate left and left->down
                if(board[this.coordinate[0]][this.coordinate[1] - 1] == 0
                    &&board[this.coordinate[0] + 1][this.coordinate[1] - 1] == 0) {
                    return true;
                }
            }
            if(this.type == 3) {//check coordinate left
                if(board[this.coordinate[0]][this.coordinate[1] - 1] == 0) {
                    return true;
                }
            }
        }
        catch(Exception e) {
            return false;
        }
        
        return false;
    }
}

class GameState {      
    public int[][] board = new int[5][4];
    public GameState parent = null;
    public int cost = 0;
    public int steps = 0;


    public GameState(int [][] inputBoard, int steps) {
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 4; j++)
                this.board[i][j] = inputBoard[i][j];
        this.steps = steps;
    }

    public GameState(int [][] inputBoard, GameState parent) {
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 4; j++)
                this.board[i][j] = inputBoard[i][j];
        this.parent = parent;
    }
    
    public GameState(int [][] inputBoard) {
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 4; j++)
                this.board[i][j] = inputBoard[i][j];
    }

            
    // get all successors and return them in sorted order
    public List<GameState> getNextStates() {
        List<GameState> successors = new ArrayList<>();        
        //figure out positions
        int[][]newBoard = board.clone();
        List<Block> blockList = new ArrayList<Block>();
        ArrayList<Integer>checkedCoordinates = new ArrayList<Integer>();
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if(newBoard[i][j] == 1) {//2x2 block
                    if(checkedCoordinates.contains(i * 10 +j))//coordinated already recorded
                        continue;
                    int[]position = new int[2];
                    position[0] = i;
                    position[1] = j;
                    checkedCoordinates.add((i + 1) * 10 + j);
                    checkedCoordinates.add(i * 10 + j + 1);
                    checkedCoordinates.add((i + 1) * 10 + j + 1);
                    Block addBlock = new Block(1, position);
                    blockList.add(addBlock);
                }
                else if(newBoard[i][j] == 2) {//2x1 block
                    if(checkedCoordinates.contains(i * 10 +j))//coordinated already recorded
                        continue;
                    int[]position = new int[2];
                    position[0] = i;
                    position[1] = j;
                    checkedCoordinates.add((i + 1) * 10 + j);
                    Block addBlock = new Block(2, position);
                    blockList.add(addBlock);
                }
                else if(newBoard[i][j] == 3) {//1x2 block
                    if(checkedCoordinates.contains(i * 10 +j))//coordinated already recorded
                        continue;
                    int[]position = new int[2];
                    position[0] = i;
                    position[1] = j;
                    checkedCoordinates.add(i * 10 + j + 1);
                    Block addBlock = new Block(3, position);
                    blockList.add(addBlock);
                }
                else if(newBoard[i][j] == 4) {//1x1 block
                    int[]position = new int[2];
                    position[0] = i;
                    position[1] = j;
                    Block addBlock = new Block(4, position);
                    blockList.add(addBlock);
                }
            }
        }
        
        for (int i = 0; i < blockList.size(); i++) {//check movable positions
            ArrayList<GameState>newNodes = blockList.get(i).checkMovablePositions(newBoard, this);
            successors.addAll(newNodes);
        }
        
        //sort list
        for(int i = 0; i < successors.size(); i++) {
            for (int j = 0; j < successors.size() - 1; j++) {
                if(successors.get(j).getStateID().compareTo(
                    successors.get(j + 1).getStateID()) > 0) {
                    GameState temp = successors.get(j);
                    successors.set(j, successors.get(j + 1));
                    successors.set(j + 1, temp);
                }
            }
        }
        
        return successors;
    }

    // return the 20-digit number as ID
    public String getStateID() {  
        String s = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)
                s += this.board[i][j];
        }
        return s;
    }

    public void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(this.board[i][j]);
            System.out.println();
        }
    }

    // check whether the current state is the goal
    public boolean goalCheck() {        
        if(board[3][1] == 1 && board[3][2] == 1 && board[4][1] == 1 && board[4][2] == 1) {
            return true;
        }
        return false;
    }

    public int getManhattanDistance() {//get manhattan distance
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] == 1) {
                    return (Math.abs(3-i) + Math.abs(1-j));//difference in x and y coordinate
                }
            }
        }
        return 0;
    }

    // add new methods for the GameState if necessary        

}

class AStarSearch{
    Queue<GameState> openSet;
    Set<GameState> closedSet;

    //Comparator for the GameState
    public Comparator<GameState> stateComparator = new Comparator<GameState>() {
        @Override
        public int compare(GameState o1, GameState o2) {
            if (o1.cost - o2.cost != 0)
                return o1.cost - o2.cost;
            else
                return o1.getStateID().compareTo(o2.getStateID());
        }
    };   

    // print the states of board in open set
    public void printOpenList(int flag, GameState state, Queue<GameState> pq) {
        if(flag == 200) {
            System.out.println("OPEN");
            ArrayList<GameState>openList = new ArrayList<GameState>();
            while(!pq.isEmpty()) {
                openList.add(pq.remove());
            }
            while(!openList.isEmpty()) {//move elements
                GameState addBack = openList.remove(0);
                System.out.println(addBack.getStateID());
                addBack.printBoard();
                System.out.println(addBack.cost + " " + addBack.steps + " 0");
                pq.add(addBack);
            }
        }
        if(flag == 400) {
            System.out.println("OPEN");
            ArrayList<GameState>openList = new ArrayList<GameState>();
            while(!pq.isEmpty()) {
                openList.add(pq.remove());
            }
            while(!openList.isEmpty()) {
                GameState addBack = openList.remove(0);
                System.out.println(addBack.getStateID());
                addBack.printBoard();
                System.out.println(addBack.cost + " " + addBack.steps + " "+ addBack.getManhattanDistance());
                pq.add(addBack);
            }
        }
        
    }

    public void printClosedList(int flag, GameState state, ArrayList<GameState> closedSet) {
        if(flag == 200) {
            System.out.println("CLOSED");
            for (GameState s: closedSet) {
                System.out.println(s.getStateID());
                s.printBoard();
                System.out.println(s.cost + " " + s.steps + " 0");
                if(s.parent == null) {
                    System.out.println("null");
                }
                else {
                    System.out.println(s.parent.getStateID());
                }
            }
        }
        if(flag == 400) {//move elements
            System.out.println("CLOSED");
            for (GameState s: closedSet) {
                System.out.println(s.getStateID());
                s.printBoard();
                System.out.println(s.cost + " " + s.steps + " " + s.getManhattanDistance());
                if(s.parent == null) {
                    System.out.println("null");
                }
                else {
                    System.out.println(s.parent.getStateID());
                }
            }
        }
    }
    
    // implement the A* search
    public GameState aStarSearch(int flag, GameState state) {   
        // feel free to using other data structures if necessary
        openSet = new PriorityQueue<>(stateComparator);
        closedSet = new HashSet<>();
        ArrayList<GameState>printClosedSet = new ArrayList<GameState>();
        ArrayList<String>checkedID = new ArrayList<String>();
        int goalCheck = 0;
        int maxOPEN = -1;
        int maxCLOSED = -1;
        int steps = 0;
        boolean goalMet = false;
        GameState finalGoal = state;
        
        int iterations = 0;
        while(!goalMet) {//goal not met
            if(flag == 200 || flag == 400) 
                System.out.println("iteration " + ++iterations);
            
            //implement search
            if(openSet.isEmpty())//1st element
                openSet.add(state);
            
            GameState popped = openSet.remove();
            checkedID.add(popped.getStateID());

            
            if(popped.goalCheck()) {//puzzle completed
                goalMet = true;
                goalCheck++;
                finalGoal = popped;
            }
            else {
                goalCheck++;
                
                List<GameState>toAdd = popped.getNextStates();
                
                if(flag == 200 || flag == 300) {
                    for(int i = 0; i < toAdd.size(); i++) {
                        toAdd.get(i).steps = popped.steps + 1;
                        toAdd.get(i).cost = toAdd.get(i).steps;
                    }
                }
                else {//flag == 400 or 500
                    for(int i = 0; i < toAdd.size(); i++) {
                        toAdd.get(i).steps = popped.steps + 1;
                        toAdd.get(i).cost = toAdd.get(i).steps + toAdd.get(i).getManhattanDistance();
                    }
                }
                while(!toAdd.isEmpty()) {
                    if(checkedID.contains(toAdd.get(0).getStateID()))
                        toAdd.remove(0);
                    else {
                        checkedID.add(toAdd.get(0).getStateID());
                        openSet.add(toAdd.remove(0));   
                    }
                }
                maxOPEN = Integer.max(maxOPEN, openSet.size());
                closedSet.add(popped);
                maxCLOSED = Integer.max(maxCLOSED, closedSet.size());
                printClosedSet.add(popped);
            }
            //print stuff
            if(flag == 200) {
                System.out.println(popped.getStateID());
                popped.printBoard();
                System.out.println(popped.cost + " " + popped.steps + " 0");
                if(popped.parent == null) {
                    System.out.println("null");
                }
                else
                    System.out.println(popped.parent.getStateID());
                
                if(!goalMet) {//print open and closed
                    printOpenList(200, state, openSet);
                    printClosedList(200, state, printClosedSet);
                }
            }
          if(flag == 400) {
              System.out.println(popped.getStateID());
              popped.printBoard();
              System.out.println(popped.cost + " " + popped.steps + " " + popped.getManhattanDistance());
              if(popped.parent == null) {
                  System.out.println("null");
              }
              else
                  System.out.println(popped.parent.getStateID());
              
              if(!goalMet) {//print open and closed
                  printOpenList(400, state, openSet);
                  printClosedList(400, state, printClosedSet);
              }
          }
        }
        
        if(flag == 300 || flag == 500) {
            steps = finalGoal.steps;
            GameState toAdd = finalGoal;
            ArrayList<GameState>stepList = new ArrayList<GameState>();
            while(toAdd != null) {
                stepList.add(0, toAdd);
                toAdd = toAdd.parent;
            }
            
            for(GameState s: stepList) {
                s.printBoard();
                System.out.println("");
            }
            
            System.out.println("goalCheckTimes " + goalCheck);
            System.out.println("maxOPENSize " + maxOPEN);
            System.out.println("maxCLOSEDSize " + maxCLOSED);
            System.out.println("steps " + steps);
        }
        return state;
    }    

    // add more methods for the A* search if necessary
}

public class Klotski {   
    public static void printNextStates(GameState s) {
        List<GameState> states = s.getNextStates();
        for (GameState state: states) {
            state.printBoard();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args == null || args.length < 21) {
            return;
        }
        int flag = Integer.parseInt(args[0]);
        int[][] board = new int[5][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = Integer.parseInt(args[i * 4 + j + 1]);
            }                
        }        
        GameState s = new GameState(board, 0);

        if (flag == 100) {
            printNextStates(s);
            return;
        }
        
        AStarSearch search = new AStarSearch();        
        search.aStarSearch(flag, s);  
        
    }

}
