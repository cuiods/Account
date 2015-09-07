package nju.model;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.*;

public class MusicThread extends Thread{

	private String fileName;
	private boolean isContinous;
	private boolean isStop;
	
	public MusicThread(String fileName, boolean isContinous) {
		this.fileName = fileName;
		this.isContinous = isContinous;
	}
	@Override
	public void run() {
		play();
	}
	
	private void play(){
		do{
			try {
				if(isStop){
					break;
				}
				AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
				AudioFormat format = ais.getFormat();
				
				DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,format, AudioSystem.NOT_SPECIFIED);
				SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
				sourceDataLine.open(format);
				sourceDataLine.start();
				
				int count;
				byte tempBuffer[] = new byte[1024];
				while ((count = ais.read(tempBuffer, 0, tempBuffer.length)) != -1) {
					if (count > 0) {
						sourceDataLine.write(tempBuffer, 0, count);
					}
					if(isStop){
						break;
					}
				}
				
				sourceDataLine.drain();
				sourceDataLine.close();
				
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		}while(isContinous);
	}
	
	public void stopMusic(){
		isStop = true;
	}

}
