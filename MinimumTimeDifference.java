class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int minDistance = Integer.MAX_VALUE;

        List<Integer> minutesList = new ArrayList<>();
        
        for( String time : timePoints ){
            minutesList.add( timeToMinutes(time) );
        }

        Collections.sort(minutesList);

        for( int i = 1; i < minutesList.size(); i++ ){
            int diff =  minutesList.get(i) - minutesList.get(i-1);
            minDistance = Math.min(minDistance, diff);
        }

        int midnightDistance = 1440 - ( minutesList.get( minutesList.size()-1) - minutesList.get(0));
        minDistance = Math.min( minDistance, midnightDistance);
        return minDistance;

    }


    private static int timeToMinutes(String time){
            String[] temp = time.split(":");
            int hours = Integer.parseInt( temp[0] );
            int minutes = Integer.parseInt( temp[1] );
            return hours*60+minutes;
    }

}