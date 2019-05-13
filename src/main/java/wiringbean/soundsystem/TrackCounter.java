package wiringbean.soundsystem;

import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {
    private Map<Integer, Integer> trackCount = new HashMap<Integer, Integer>();

    @Pointcut("execution(* wiringbean.soundsystem.BlankDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {}



}
