package eeeee;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.control.Slider;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings({ "serial", "unused" })

//medidores dos valores de saturação nas configs avançadas
//o programador não se responsabiliza por efeitos psicológicos causados no leitor

public class sliders {
	
	public static class S1 extends JFrame {
		JSlider Slide = new JSlider(0, 255);
		public S1 () {
			setTitle("Saturação 1");
			setSize(300, 100);
			add(Slide);
			setAlwaysOnTop(true);
			Slide.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					Bert.TrocaValores(1, Slide.getValue());
					
				}
			});
		}
	}
	public static class S2 extends JFrame {
		JSlider Slide = new JSlider(0, 255);
		public S2 () {
			setTitle("Saturação 2");
			setSize(300, 100);
			add(Slide);
			setAlwaysOnTop(true);
			Slide.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					Bert.TrocaValores(2, Slide.getValue());
					
				}
			});
		}
	}
	public static class S3 extends JFrame {
		JSlider Slide = new JSlider(0, 255);
		public S3 () {
			setTitle("Saturação 3");
			setSize(300, 100);
			add(Slide);
			setAlwaysOnTop(true);
			Slide.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					Bert.TrocaValores(3, Slide.getValue());
					
				}
			});
		}
	}
	public static class S4 extends JFrame {
		JSlider Slide = new JSlider(0, 255);
		public S4 () {
			setTitle("Saturação 4");
			setSize(300, 100);
			add(Slide);
			setAlwaysOnTop(true);
			Slide.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					Bert.TrocaValores(4, Slide.getValue());
					
				}
			});
		}
	}
	public static class S5 extends JFrame {
		JSlider Slide = new JSlider(5, 255);
		public S5 () {
			setTitle("Saturação 5");
			setSize(300, 100);
			add(Slide);
			setAlwaysOnTop(true);
			Slide.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					Bert.TrocaValores(5, Slide.getValue());
					
				}
			});
		}
	}
	
	
	
}
