package goalkeper;

import goal.GameGoal;
import goal.InGoal;
import goalkeper.components.DefenseArea;
import goalkeper.components.InitPosition;
import goalkeper.components.LeftHand;
import goalkeper.components.RightHand;

import java.util.ArrayList;
import java.util.Random;

public class ActingArea{

    protected ArrayList<DefensePoint>   actingAreaList;
    protected InitPosition              initPosition;
    protected LeftHand                  leftHand;
    protected RightHand                 rightHand;
    protected GameGoal                  gameGoal;
    protected ArrayList<InGoal>         goalArea;

    public ActingArea(GameGoal gameGoal) {

        actingAreaList = new ArrayList<>();

        this.gameGoal = gameGoal;

        goalArea = gameGoal.getInGoalPart();

        setMainPositions();
    }

    public void setMainPositions(){

        setLeftHand();
        setRightHand();
        setInitPosition();
        setDefenseArea();

    }

    private ArrayList<InGoal> getGoalAreaLeftSide(){
        ArrayList<InGoal> goalArea = gameGoal.getInGoalPart();
        ArrayList<InGoal> goalArealLeftSide = new ArrayList<>();

        for (InGoal inGoal: goalArea){
            if (inGoal.getColumPosition() <= gameGoal.getWidth()/2){
                goalArealLeftSide.add(inGoal);
            }
        }

        return goalArealLeftSide;
    }
    private void setLeftHand(){
        Random point = new Random();
        ArrayList<InGoal> goalAreaLeftSide = getGoalAreaLeftSide();


         InGoal inGoal = goalAreaLeftSide.get(point.nextInt(0, goalAreaLeftSide.size()));

         leftHand = new LeftHand(
                 inGoal.getLinePosition(), inGoal.getColumPosition(),
                 inGoal.getCounterPanel(), inGoal.getStartZone()
         );

         actingAreaList.add(leftHand);
    }

    private ArrayList<InGoal> getGoalAreaRightSide(){
        int origin = leftHand.getColumPosition() + 2;

        ArrayList<InGoal> goalArea  = gameGoal.getInGoalPart();
        ArrayList<InGoal> rightSide = new ArrayList<>();

        for (InGoal inGoal: goalArea){
            if (inGoal.getColumPosition() > origin){
                rightSide.add(inGoal);
            }
        }

        return rightSide;
    }
    private void setRightHand(){
        ArrayList<InGoal> goalAreaRightSide = getGoalAreaRightSide();
        Random point = new Random();

        InGoal inGoal = goalAreaRightSide.get(point.nextInt(0, goalAreaRightSide.size()));

        rightHand = new RightHand(
                inGoal.getLinePosition(), inGoal.getColumPosition(),
                inGoal.getCounterPanel(), inGoal.getStartZone()
        );

        actingAreaList.add(rightHand);

    }

    private ArrayList<InGoal> getInitPosArea(){
        ArrayList<InGoal> initArea = new ArrayList<>();

        for (InGoal inGoal: gameGoal.getInGoalPart()){
            if (inGoal.getLinePosition() == gameGoal.getHigh() - 1){
                initArea.add(inGoal);
            }
        }

        return initArea;
    }

    private void setInitPosition(){
        ArrayList<InGoal> goalInitArea = getInitPosArea();
        Random point = new Random();

        InGoal inGoal = goalInitArea.get(point.nextInt(0, goalInitArea.size()));

        initPosition = new InitPosition(
                inGoal.getLinePosition(), inGoal.getColumPosition(),
                inGoal.getCounterPanel(), inGoal.getStartZone()
        );

        actingAreaList.add(initPosition);
    }

    public ArrayList<DefensePoint> getActingAreaList() {
        return actingAreaList;
    }

    private void setDefenseArea(){
        searchHand(initPosition, leftHand);
        searchHand(initPosition, rightHand);
    }

    public void searchHand(InitPosition initPosition, DefensePoint hand){
        int indexHigh = gameGoal.getHigh() - 1;

        while (indexHigh != hand.getLinePosition()){

            indexHigh--;
            if (isNotDefensePoint(indexHigh, initPosition.getColumPosition())) {

                actingAreaList.add(new DefenseArea(indexHigh, initPosition.getColumPosition(),
                        gameGoal.getCounterPanel(), gameGoal.getStartZone()));

            }

            if (indexHigh == 0){
                break;
            }

        }

        int indexWidth = initPosition.getColumPosition();

        while ((indexWidth != hand.getColumPosition() - 1) && (indexWidth != hand.getColumPosition() + 1)){
            if (hand.getColumPosition() - indexWidth < 0){
                indexWidth--;
            } else
                indexWidth++;

            if (isNotDefensePoint(indexHigh, indexWidth)) {

                actingAreaList.add(new DefenseArea(indexHigh, indexWidth, initPosition.getCounterPanel(),
                        initPosition.getStartZone()));
            }

        }
    }

    private boolean isNotDefensePoint(int line, int colum){

        for (DefensePoint defensePoint: actingAreaList) {
            if (defensePoint.getColumPosition() == colum && defensePoint.getLinePosition() == line)
                return false;
        }

        return true;
    }

}
