package br.sp.senai.jandira.conversor_temperatura.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.sp.senai.jandira.conversor_temperatura.model.Temperatura;

public class TelaConversor {

	private JLabel labelCelsius;
	private JTextField textCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelmensagemErro;

	public void criarTelaConversor() {

		// Criando o JFrame e os objetos que irão dentro dele
		JFrame tela = new JFrame();
		tela.setSize(500, 400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor de Temperatura");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);

		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(20, 30, 460, 30);

		textCelsius = new JTextField();
		textCelsius.setBounds(20, 70, 450, 30);

		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("FAHREINHEIT");
		buttonFahreinheit.setBounds(20, 110, 220, 30);

		buttonKelvin = new JButton();
		buttonKelvin.setText("KELVIN");
		buttonKelvin.setBounds(250, 110, 220, 30);

		labelResultado = new JLabel();
		labelResultado.setText("Resultado:");
		labelResultado.setBounds(200, 170, 300, 30);

		labelmensagemErro = new JLabel();
		labelmensagemErro.setText("Valor inserido inválido!");
		labelmensagemErro.setBounds(180, 230, 200, 30);
		labelmensagemErro.setForeground(Color.red);
		labelmensagemErro.setVisible(false);

		// Colocar os componentes no objeto de conteudo
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelmensagemErro);

		// aciona os calculos de kelvin após clicar no botão
		buttonKelvin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// transfere o valor do textfield para uma variavel para facilitar a manipulação
				String celsius = textCelsius.getText();
				
				// estrutura responsável por verificar se o valor digitado pode ser um double ou não
				boolean Converter = false;
				try {
					Double.parseDouble(celsius);
					Converter = true;
				} catch (NumberFormatException erro) {
					Converter = false;
				}

				if (Converter) {

					// Mantem a mensagem de erro oculta
					labelmensagemErro.setVisible(false);

					// casting
					double celsiusDouble = Double.parseDouble(celsius);

					// criação e utilização dos métodos do objeto
					Temperatura kelvin = new Temperatura();
					kelvin.setCelsius(celsiusDouble);
					celsiusDouble = kelvin.converterParaKelvin();

					// Atribuir valor para o labelResultado
					labelResultado.setText(String.valueOf("Resultado: " + celsiusDouble));

				} else {

					// Mostra a mensagem de erro
					labelmensagemErro.setVisible(true);
					labelResultado.setText(String.valueOf("Resultado: Erro!"));

				}

			}
			
		});

		// aciona os calculos de fahreinheit após clicar no botão
		buttonFahreinheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// transfere o valor do textfield para uma variavel para facilitar a manipulação
				String celsius = textCelsius.getText();
				
				// estrutura responsável por verificar se o valor digitado pode ser um double ou não
				boolean Converter = false;
				try {
					Double.parseDouble(celsius);
					Converter = true;
				} catch (NumberFormatException erro) {
					Converter = false;
				}

				if (Converter) {

					// Mantem a mensagem de erro oculta
					labelmensagemErro.setVisible(false);

					// casting
					double celsiusDouble = Double.parseDouble(celsius);

					// criação e utilização dos métodos do objeto
					Temperatura fahreinheit = new Temperatura();
					fahreinheit.setCelsius(celsiusDouble);
					celsiusDouble = fahreinheit.converterParaFahreinheit();

					// Atribuir valor para o labelResultado
					labelResultado.setText(String.valueOf("Resultado: " + celsiusDouble));

				} else {

					// Mostra a mensagem de erro
					labelmensagemErro.setVisible(true);
					labelResultado.setText(String.valueOf("Resultado: Erro!"));

				}

			}
		});

		tela.setVisible(true);

	}

}
