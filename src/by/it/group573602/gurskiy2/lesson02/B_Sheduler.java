package by.it.group573602.gurskiy2.lesson02;

import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_Sheduler {
    //событие у аудитории(два поля: начало и конец)
    static class Event implements Comparable{
        int start;
        int stop;
        public int compareTo(Object obj)
        {
            Event tmp = (Event)obj;
            if(this.stop < tmp.stop)
            {
                return -1;
            }
            else if(this.stop > tmp.stop)
            {
                return 1;
            }
            return 0;
        }
        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        public int getStop() {
            return stop;
        }

        public int getStart() {
            return start;
        }

        @Override
        public String toString() {
            return "("+ start +":" + stop + ")";
        }
    }

    public static void main(String[] args) {
        B_Sheduler instance = new B_Sheduler();
        Event[] events = {  new Event(0, 3),  new Event(0, 1), new Event(1, 2), new Event(3, 5),
                            new Event(1, 3),  new Event(1, 3), new Event(1, 3), new Event(3, 6),
                            new Event(2, 7),  new Event(2, 3), new Event(2, 7), new Event(7, 9),
                            new Event(3, 5),  new Event(2, 4), new Event(2, 3), new Event(3, 7),
                            new Event(4, 5),  new Event(6, 7), new Event(6, 9), new Event(7, 9),
                            new Event(8, 9),  new Event(4, 6), new Event(8, 10), new Event(7, 10)
                          };

        List<Event> starts = instance.calcStartTimes(events,0,10);  //рассчитаем оптимальное заполнение аудитории
        System.out.println(starts);                                 //покажем рассчитанный график занятий
    }

    List<Event> calcStartTimes(Event[] events, int from, int to) {
        //events - события которые нужно распределить в аудитории
        //в период [from, int] (включительно).
        //оптимизация проводится по наибольшему числу непересекающихся событий.
        //начало и конец событий могут совпадать.
        List<Event> result;
        result = new ArrayList<>();
        Arrays.sort(events);
        //ваше решение.
        int i, sizeOfResultTemp=0;
        result.add(events[0]);
        for(i=1;i<events.length;i++) {
            if(events[i].getStart()>=result.get(sizeOfResultTemp).getStop()) {
                result.add(events[i]);
                sizeOfResultTemp++;
            }
        }



        return result;                        //вернем итог
    }
}