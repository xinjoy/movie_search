package main;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class main extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private JPanel genres_panel;
	private JPanel countries_panel;
	private JPanel locations_panel;
	private JPanel tags_panel;
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;
	
	private JTextArea textArea;

	private JTable table;
	
	private JButton btnOk;
	private JButton btnOk_1;
	private JButton btnOk_2;
	private JButton btnOk_3;
	private JButton button;
	
	private ArrayList<String> chooseGenres = new ArrayList<String>();
	private ArrayList<String> chooseCountries = new ArrayList<String>();
	private ArrayList<String> chooseLocations = new ArrayList<String>();
	private ArrayList<String> chooseTags = new ArrayList<String>();
	
	private String[] logicSymbolArray = {"intersect", "union"};
	private String setLogicSymbol = "intersect";
	private String updateQueryAfterRatingNumYear = "";
	private String updateQueryAfterWeight = "";
	private String showQuery;
	
	public main() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 152, 165, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 86, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnMovie = new JButton("Movie");
		btnMovie.setBackground(Color.CYAN);
		btnMovie.setOpaque(true);
		btnMovie.setBorderPainted(false);
		GridBagConstraints gbc_btnMovie = new GridBagConstraints();
		gbc_btnMovie.insets = new Insets(0, 0, 1, 0);
		gbc_btnMovie.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMovie.gridwidth = 5;
		gbc_btnMovie.gridx = 0;
		gbc_btnMovie.gridy = 0;
		getContentPane().add(btnMovie, gbc_btnMovie);
		
		JButton btnGenres = new JButton("Genres");
		btnGenres.setBackground(Color.LIGHT_GRAY);
		btnGenres.setOpaque(true);
		btnGenres.setBorderPainted(false);
		btnGenres.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnGenres = new GridBagConstraints();
		gbc_btnGenres.insets = new Insets(0, 0, 1, 1);
		gbc_btnGenres.fill = GridBagConstraints.BOTH;
		gbc_btnGenres.gridx = 0;
		gbc_btnGenres.gridy = 1;
		getContentPane().add(btnGenres, gbc_btnGenres);
		
		JButton btnCountry = new JButton("Country");
		btnCountry.setBackground(Color.LIGHT_GRAY);
		btnCountry.setOpaque(true);
		btnCountry.setBorderPainted(false);
		btnCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnCountry = new GridBagConstraints();
		gbc_btnCountry.insets = new Insets(0, 0, 1, 1);
		gbc_btnCountry.fill = GridBagConstraints.BOTH;
		gbc_btnCountry.gridx = 1;
		gbc_btnCountry.gridy = 1;
		getContentPane().add(btnCountry, gbc_btnCountry);
		
		JButton btnFilmingLocationCountry = new JButton("Filming Location Country");
		btnFilmingLocationCountry.setBackground(Color.LIGHT_GRAY);
		btnFilmingLocationCountry.setOpaque(true);
		btnFilmingLocationCountry.setBorderPainted(false);
		btnFilmingLocationCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnFilmingLocationCountry = new GridBagConstraints();
		gbc_btnFilmingLocationCountry.fill = GridBagConstraints.BOTH;
		gbc_btnFilmingLocationCountry.insets = new Insets(0, 0, 1, 1);
		gbc_btnFilmingLocationCountry.gridx = 2;
		gbc_btnFilmingLocationCountry.gridy = 1;
		getContentPane().add(btnFilmingLocationCountry, gbc_btnFilmingLocationCountry);
		
		JButton btnCriticsRating = new JButton("Critics' Rating");
		btnCriticsRating.setBackground(Color.LIGHT_GRAY);
		btnCriticsRating.setOpaque(true);
		btnCriticsRating.setBorderPainted(false);
		btnCriticsRating.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnCriticsRating = new GridBagConstraints();
		gbc_btnCriticsRating.fill = GridBagConstraints.BOTH;
		gbc_btnCriticsRating.insets = new Insets(0, 0, 1, 1);
		gbc_btnCriticsRating.gridx = 3;
		gbc_btnCriticsRating.gridy = 1;
		getContentPane().add(btnCriticsRating, gbc_btnCriticsRating);
		
		JButton btnMovieTagValues = new JButton("Movie Tag Values");
		btnMovieTagValues.setBackground(Color.LIGHT_GRAY);
		btnMovieTagValues.setOpaque(true);
		btnMovieTagValues.setBorderPainted(false);
		btnMovieTagValues.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnMovieTagValues = new GridBagConstraints();
		gbc_btnMovieTagValues.insets = new Insets(0, 0, 1, 0);
		gbc_btnMovieTagValues.fill = GridBagConstraints.BOTH;
		gbc_btnMovieTagValues.gridx = 4;
		gbc_btnMovieTagValues.gridy = 1;
		getContentPane().add(btnMovieTagValues, gbc_btnMovieTagValues);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 1, 1);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 2;
		getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_6);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblRating.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(lblRating);
		
		String[] string1 = {"", "=", "<", ">", "<=", ">="};
		comboBox = new JComboBox<String>(string1);	
		comboBox.setMaximumRowCount(6);
		panel_6.add(comboBox);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_7.setBackground(Color.WHITE);
		panel_1.add(panel_7);
		
		JLabel lblValue = new JLabel("Value:");
		lblValue.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_7.add(lblValue);
		
		textField = new JTextField();
		panel_7.add(textField);
		textField.setColumns(6);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_1.add(panel_14);
		
		btnOk = new JButton("OK");
		panel_14.add(btnOk);
		
		genres_panel = new JPanel();
		scrollPane_1 = new JScrollPane(genres_panel);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 1, 1);
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		countries_panel = new JPanel();
		scrollPane_2 = new JScrollPane(countries_panel);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 1, 1);
		gbc_scrollPane_2.gridheight = 3;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 2;
		getContentPane().add(scrollPane_2, gbc_scrollPane_2);
		
		locations_panel = new JPanel();
		scrollPane_3 = new JScrollPane(locations_panel);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 0, 1, 1);
		gbc_scrollPane_3.gridheight = 3;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 2;
		gbc_scrollPane_3.gridy = 2;
		getContentPane().add(scrollPane_3, gbc_scrollPane_3);
		
		tags_panel = new JPanel();
		scrollPane_4 = new JScrollPane(tags_panel);
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.gridheight = 3;
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 4;
		gbc_scrollPane_4.gridy = 2;
		getContentPane().add(scrollPane_4, gbc_scrollPane_4);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 1, 1);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 3;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_9.setBackground(Color.WHITE);
		panel.add(panel_9);
		
		JLabel lblNumOfReviews = new JLabel("Num. of Reviews:");
		lblNumOfReviews.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_9.add(lblNumOfReviews);
		
		String[] string2 = {"", "=", "<", ">", "<=", ">="};
		comboBox_1 = new JComboBox<String>(string2);
		comboBox_1.setMaximumRowCount(6);
		panel_9.add(comboBox_1);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_8.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_8.setBackground(Color.WHITE);
		panel.add(panel_8);
		
		JLabel lblValue_1 = new JLabel("Value:");
		lblValue_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_8.add(lblValue_1);
		
		textField_1 = new JTextField();
		panel_8.add(textField_1);
		textField_1.setColumns(6);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel.add(panel_15);
		
		btnOk_1 = new JButton("OK");
		panel_15.add(btnOk_1);
		
		JButton btnMovieYear = new JButton("Movie Year");
		btnMovieYear.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnMovieYear.setBackground(Color.LIGHT_GRAY);
		btnMovieYear.setOpaque(true);
		btnMovieYear.setBorderPainted(false);
		GridBagConstraints gbc_btnMovieYear = new GridBagConstraints();
		gbc_btnMovieYear.insets = new Insets(0, 0, 1, 1);
		gbc_btnMovieYear.fill = GridBagConstraints.BOTH;
		gbc_btnMovieYear.gridx = 3;
		gbc_btnMovieYear.gridy = 4;
		getContentPane().add(btnMovieYear, gbc_btnMovieYear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_2.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 1, 1);
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		getContentPane().add(panel_2, gbc_panel_2);
		
		JLabel lblSearchBwtween = new JLabel("Search Between Attributes' Values:");
		lblSearchBwtween.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchBwtween.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		panel_2.add(lblSearchBwtween);
		
		String[] andOr = {"AND", "OR"};
		comboBox_2 = new JComboBox<String>(andOr);
		comboBox_2.setMaximumRowCount(3);
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int index = comboBox_2.getSelectedIndex();
					if (index == 0) {
						setLogicSymbol = logicSymbolArray[0];
					}
					else if (index == 1){
						setLogicSymbol = logicSymbolArray[1];
					}
				}
			}
		});
		panel_2.add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 1, 1);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 5;
		getContentPane().add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		FlowLayout flowLayout_5 = (FlowLayout) panel_10.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_10);
		
		JLabel lblFrom = new JLabel("from");
		lblFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_10.add(lblFrom);
		
		textField_3 = new JTextField();
		panel_10.add(textField_3);
		textField_3.setColumns(6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		FlowLayout flowLayout_6 = (FlowLayout) panel_11.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_11);
		
		JLabel lblTo = new JLabel("  to  ");
		lblTo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_11.add(lblTo);
		
		textField_4 = new JTextField();
		panel_11.add(textField_4);
		textField_4.setColumns(6);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		panel_3.add(panel_17);
		
		btnOk_2 = new JButton("OK");
		panel_17.add(btnOk_2);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 1, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 5;
		getContentPane().add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		FlowLayout flowLayout_7 = (FlowLayout) panel_13.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_13);
		
		JLabel lblTagWeight = new JLabel("Tag Weight:");
		lblTagWeight.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_13.add(lblTagWeight);
		
		String[] string3 = {"", "=", "<", ">"};
		comboBox_3 = new JComboBox<String>(string3);
		comboBox_3.setMaximumRowCount(4);
		panel_13.add(comboBox_3);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		FlowLayout flowLayout_8 = (FlowLayout) panel_12.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_12);
		
		JLabel lblValue_2 = new JLabel("Value:");
		lblValue_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_12.add(lblValue_2);
		
		textField_2 = new JTextField();
		panel_12.add(textField_2);
		textField_2.setColumns(6);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		panel_4.add(panel_18);
		
		btnOk_3 = new JButton("OK");
		btnOk_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String weightRelationSymbol = String.valueOf(comboBox_3.getSelectedItem());
				String weightValue = textField_2.getText();
				
				updateQueryAfterWeight = "select MT.mid from Movie_tags MT where MT.tag_weight " 
						+ weightRelationSymbol + " " + weightValue;
			}
		});
		panel_18.add(btnOk_3);
		
		JButton btnResult = new JButton("Result");
		btnResult.setBackground(Color.CYAN);
		btnResult.setOpaque(true);
		btnResult.setBorderPainted(false);
		GridBagConstraints gbc_btnResult = new GridBagConstraints();
		gbc_btnResult.insets = new Insets(0, 0, 1, 0);
		gbc_btnResult.fill = GridBagConstraints.BOTH;
		gbc_btnResult.gridwidth = 2;
		gbc_btnResult.gridx = 3;
		gbc_btnResult.gridy = 6;
		getContentPane().add(btnResult, gbc_btnResult);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 1);
		gbc_panel_5.gridheight = 2;
		gbc_panel_5.gridwidth = 3;
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 6;
		getContentPane().add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{326, 0};
		gbl_panel_5.rowHeights = new int[]{58, 58, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		panel_5.add(new JScrollPane(textArea), gbc_textArea);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 2;
		panel_5.add(panel_16, gbc_panel_16);
		
		JButton btnShowQuery = new JButton("Show Query");
		btnShowQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String updateQueryAfterGenre = "";
				String updateQueryAfterGenrePublic = "select G.mid from Movie_genres G where ";
				String logicSymbol = "\n" + setLogicSymbol + "\n";
				int count1 = 0;
				
				for (String chooseGenresName: chooseGenres) {
					if (count1 == 0) {
						updateQueryAfterGenre += updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					else {
						updateQueryAfterGenre += logicSymbol + updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					count1 = 1;
				}
				
				String updateQueryAfterCountry = "";
				String updateQueryAfterCountryPublic = "select C.mid from Movie_countries C where ";
				int count2 = 0;
				
				for (String chooseCountriesName: chooseCountries) {
					if (count2 == 0) {
						updateQueryAfterCountry += updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					else {
						updateQueryAfterCountry += logicSymbol + updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					count2 = 1;
				}
				
				String updateQueryAfterLocation = "";
				String updateQueryAfterLocationPublic = "select L.mid from Movie_locations L where ";
				int count3 = 0;
				
				for (String chooseLocationsName: chooseLocations) {
					if (count3 == 0) {
						updateQueryAfterLocation += updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					else {
						updateQueryAfterLocation += logicSymbol + updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					count3 = 1;
				}
				
				String updateQueryAfterTag = "";
				String updateQueryAfterTagPublic = "select MT.mid from Movie_tags MT, Tags T where MT.tid = T.tid and ";
				int count4 = 0;
				
				for (String chooseTagsName: chooseTags) {
					if (count4 == 0) {
						updateQueryAfterTag += updateQueryAfterTagPublic + "T.tag_text = '" + chooseTagsName + "'";
					}
					else {
						updateQueryAfterTag += logicSymbol + updateQueryAfterTagPublic + "T.tag_text = '" + chooseTagsName + "'";
					}
					count4 = 1;
				}
				
				String updateQuery1 = "(" + updateQueryAfterGenre + ")";
				if (!chooseCountries.isEmpty()) {
					updateQuery1 += "\n" + "intersect" + "\n" + "(" + updateQueryAfterCountry + ")";
				}
				if (!chooseLocations.isEmpty()) {
					updateQuery1 += "\n" + "intersect" + "\n" + "(" + updateQueryAfterLocation + ")";
				}
				if (!updateQueryAfterRatingNumYear.equals("")) {
					updateQuery1 += "\n" + "intersect" + "\n" + updateQueryAfterRatingNumYear;
				}
				
				String updateQuery2 = "";
				if (chooseTags.isEmpty()) {
					if (!updateQueryAfterWeight.equals("")) {
						updateQuery2 = updateQueryAfterWeight;
					}
				}
				else if (!chooseTags.isEmpty()) {
					if(updateQueryAfterWeight.equals("")) {
						updateQuery2 = "(" + updateQueryAfterTag + ")";
					}
					else if(!updateQueryAfterWeight.equals("")) {
						updateQuery2 = "(" + "(" + updateQueryAfterTag + ")" + logicSymbol + updateQueryAfterWeight + ")";
					}
				}
				
				String updateQuery;
				if (updateQuery2.equals("")) {
					updateQuery = updateQuery1;
				}
				else {
					updateQuery = updateQuery1 + "\n" + "intersect" + "\n" + updateQuery2;
				}
				
				showQuery = "select distinct M.mid as movie_id, M.title, G.genres, M.year, C.country, L.location_country," + "\n"
						+ "AVG(M.all_critics_rating + M.top_critics_rating + M.audience_rating) as critics_rating," + "\n"
						+ "AVG(M.all_critics_num_review + M.top_critics_num_review + M.audience_num_rating) as review_number" + "\n"
						+ "from Movies M, Movie_genres G, Movie_countries C, Movie_locations L" + "\n"
						+ "where M.mid = G.mid and M.mid = C.mid and M.mid = L.mid and M.mid in" + "\n" 
						+ "(" + updateQuery + ")" + "\n" 
						+ "group by M.mid, M.title, G.genres, M.year, C.country, L.location_country" + "\n"
						+ "order by M.title";
				
				textArea.setText(showQuery);
				//System.out.println(showQuery);
			}
		});
		panel_16.add(btnShowQuery);
		
		button = new JButton("Execute Query");
		panel_16.add(button);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 7;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void run() {
        Connection con = null;
        try {
            con = openConnection();
            showGenresResultSet(con);
            showMovieTagValuesResultSetAfterRating(con);
            showMovieTagValuesResultSetAfterNum(con);
            showMovieTagValuesResultSetAfterYear(con);
            runQuery(con);
        } catch (SQLException e) {
            System.err.println("Errors occurs when communicating with the database server: " + e.getMessage());
        } catch (ClassNotFoundException e) { 
        	System.err.println("Cannot find the database driver"); 
        }
    }
	
	private void showGenresResultSet(Connection con) throws SQLException {
		ArrayList<String> genres_list = new ArrayList<String>();
		
		Statement stmt = con.createStatement();
		String queryGenres = "select distinct G.genres from Movie_genres G order by G.genres";
		ResultSet genresResult = stmt.executeQuery(queryGenres);
		
		while (genresResult.next()) {   
			genres_list.add(genresResult.getString(1));
		}
		//System.out.println(genres_list);
		for (String genresName: genres_list) {
			JCheckBox genres = new JCheckBox(genresName);
			genres_panel.add(genres);
			
			genres.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					if (genres.isSelected()) {
						chooseGenres.add(genresName);
						//System.out.println(chooseGenres);
						try {
							showCountriesResultSet(con);
							showMovieTagValuesResultSetAfterGenre(con);
						} catch (SQLException e) {
							System.err.println("Errors occurs when communicating with the database server: " + e.getMessage());
						}
					}
				}
			});	
		}
		
		genres_panel.setLayout(new GridLayout(genres_list.size(), 1));
		scrollPane_1.validate();
		scrollPane_1.repaint();
	}
	
	private void showCountriesResultSet(Connection con) throws SQLException {
		ArrayList<String> countries_list = new ArrayList<String>();
		
		String queryCountries = "";
		String queryCountries1 = "select distinct C.country "
				+ "from Movie_countries C, Movie_genres G "
				+ "where C.mid = G.mid and ";
		String queryCountries2 = "\n" + "order by country";
		String logicSymbol = "\n" + setLogicSymbol + "\n";
		int count = 0;
		
		for (String chooseGenresName: chooseGenres) {
			if (count == 0) {
				queryCountries += queryCountries1 + "G.genres = '" + chooseGenresName + "'";
			}
			else {
				queryCountries += logicSymbol + queryCountries1 + "G.genres = '" + chooseGenresName + "'";
			}
			count = 1;
		}
		
		queryCountries = queryCountries + queryCountries2;
		//System.out.println(queryCountries);
		
		Statement stmt = con.createStatement();
		ResultSet countriesResult = stmt.executeQuery(queryCountries);
		
		while (countriesResult.next()) { 
			//System.out.println(countriesResult.getString(1));  
			countries_list.add(countriesResult.getString(1));
		}
		
		countries_panel.removeAll();
		
		for (String countriesName: countries_list) {
			JCheckBox countries = new JCheckBox(countriesName);
			countries_panel.add(countries);
			
			countries.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					if (countries.isSelected()) {
						chooseCountries.add(countriesName);
						//System.out.println(chooseCountries);
						try {
							showLocationResultSet(con);
							showMovieTagValuesResultSetAfterCountry(con);
						} catch (SQLException e) {
							System.err.println("Errors occurs when communicating with the database server: " + e.getMessage());
						}
					}
				}
			});
		}
		
		countries_panel.setLayout(new GridLayout(countries_list.size(), 1));
		scrollPane_2.validate();
		scrollPane_2.repaint();
	}
	
	private void showLocationResultSet(Connection con) throws SQLException {
		ArrayList<String> locations_list = new ArrayList<String>();
		
		String queryLocations = "";
		String queryLocations1 = "select distinct L.location_country "
				+ "from Movie_locations L "
				+ "where L.mid in" + "\n" + "((";
		String queryLocations2 = "select G.mid from Movie_genres G where ";
		String logicSymbol = "\n" + setLogicSymbol + "\n";
		String queryLocations3 = "";
		int count1 = 0;
		
		for (String chooseGenresName: chooseGenres) {
			if (count1 == 0) {
				queryLocations3 += queryLocations2 + "G.genres = '" + chooseGenresName + "'";
			}
			else {
				queryLocations3 += logicSymbol + queryLocations2 + "G.genres = '" + chooseGenresName + "'";
			}
			count1 = 1;
		}
		
		String intersect = ")" + "\n" + "intersect" + "\n" + "(";
		String queryLocations4 = "select C.mid from Movie_countries C where ";
		String queryLocations5 = "";
		int count2 = 0;
		
		for (String chooseCountriesName: chooseCountries) {
			if (count2 == 0) {
				queryLocations5 += queryLocations4 + "C.country = '" + chooseCountriesName + "'";
			}
			else {
				queryLocations5 += logicSymbol + queryLocations4 + "C.country = '" + chooseCountriesName + "'";
			}
			count2 = 1;
		}
		
		String queryLocations6 = "))" + "\n" + "order by L.location_country";
		queryLocations = queryLocations1 + queryLocations3 + intersect + queryLocations5 + queryLocations6;
		//System.out.println(queryLocations);
		
		Statement stmt = con.createStatement();
		ResultSet locationsResult = stmt.executeQuery(queryLocations);
		
		while (locationsResult.next()) { 
			//System.out.println(countriesResult.getString(1));  
			locations_list.add(locationsResult.getString(1));
		}
		
		locations_panel.removeAll();
		
		for (String locationsName: locations_list) {
			JCheckBox locations = new JCheckBox(locationsName);
			locations_panel.add(locations);
			
			locations.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					if (locations.isSelected()) {
						chooseLocations.add(locationsName);
						//System.out.println(chooseLocations);
						try {
							showMovieTagValuesResultSetAfterLocation(con);
						} catch (SQLException e) {
							System.err.println("Errors occurs when communicating with the database server: " + e.getMessage());
						}
					}
				}
			});
		}
		
		locations_panel.setLayout(new GridLayout(locations_list.size(), 1));
		scrollPane_3.validate();
		scrollPane_3.repaint();
	}
	
	private void showMovieTagValuesResultSetAfterGenre(Connection con) throws SQLException {
		ArrayList<String> tags_list = new ArrayList<String>();
		
		String queryTags = "";
		String queryTags1 = "select distinct T.tag_text "
				+ "from Tags T, Movie_tags MT, Movie_genres G "
				+ "where T.tid = MT.tid and MT.mid = G.mid and ";
		String queryTags2 = "\n" + "order by tag_text";
		String logicSymbol = "\n" + setLogicSymbol + "\n";
		int count = 0;
		
		for (String chooseGenresName: chooseGenres) {
			if (count == 0) {
				queryTags += queryTags1 + "G.genres = '" + chooseGenresName + "'";
			}
			else {
				queryTags += logicSymbol + queryTags1 + "G.genres = '" + chooseGenresName + "'";
			}
			count = 1;
		}
		
		String showTagsAfterGenre = queryTags + queryTags2;
		//System.out.println(showTagsAfterGenre);
		
		Statement stmt = con.createStatement();
		ResultSet tagsResult = stmt.executeQuery(showTagsAfterGenre);
		
		while (tagsResult.next()) { 
			//System.out.println(tagsResult.getString(1));  
			tags_list.add(tagsResult.getString(1));
		}
		
		tags_panel.removeAll();
		
		for (String tagsName: tags_list) {
			JCheckBox tags = new JCheckBox(tagsName);
			tags_panel.add(tags);
			
			tags.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					if (tags.isSelected()) {
						chooseTags.add(tagsName);
					}
				}
			}); 
		}
		
		tags_panel.setLayout(new GridLayout(tags_list.size(), 1));
		scrollPane_4.validate();
		scrollPane_4.repaint();
	}
	
	private void showMovieTagValuesResultSetAfterCountry(Connection con) throws SQLException {
		ArrayList<String> tags_list = new ArrayList<String>();
		
		String queryTags1 = "select distinct T.tag_text "
				+ "from Tags T, Movie_tags MT "
				+ "where T.tid = MT.tid and MT.mid in" + "\n" + "((";
		String queryTags2 = "select G.mid from Movie_genres G where ";
		String logicSymbol = "\n" + setLogicSymbol + "\n";
		String queryTags3 = "";
		int count1 = 0;
		
		for (String chooseGenresName: chooseGenres) {
			if (count1 == 0) {
				queryTags3 += queryTags2 + "G.genres = '" + chooseGenresName + "'";
			}
			else {
				queryTags3 += logicSymbol + queryTags2 + "G.genres = '" + chooseGenresName + "'";
			}
			count1 = 1;
		}
		
		String intersect = ")" + "\n" + "intersect" + "\n" + "(";
		String queryTags4 = "select C.mid from Movie_countries C where ";
		String queryTags5 = "";
		int count2 = 0;
		
		for (String chooseCountriesName: chooseCountries) {
			if (count2 == 0) {
				queryTags5 += queryTags4 + "C.country = '" + chooseCountriesName + "'";
			}
			else {
				queryTags5 += logicSymbol + queryTags4 + "C.country = '" + chooseCountriesName + "'";
			}
			count2 = 1;
		}
		
		String queryTags6 = "))" + "\n" + "order by T.tag_text"; 
		
		String showTagsAfterCountry = queryTags1 + queryTags3 + intersect + queryTags5 + queryTags6;
		//System.out.println(showTagsAfterCountry);
		
		Statement stmt = con.createStatement();
		ResultSet tagsResult = stmt.executeQuery(showTagsAfterCountry);
		
		while (tagsResult.next()) { 
			//System.out.println(tagsResult.getString(1));  
			tags_list.add(tagsResult.getString(1));
		}
		
		tags_panel.removeAll();
		
		for (String tagsName: tags_list) {
			JCheckBox tags = new JCheckBox(tagsName);
			tags_panel.add(tags);
			
			tags.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					if (tags.isSelected()) {
						chooseTags.add(tagsName);
					}
				}
			});
		}
		
		tags_panel.setLayout(new GridLayout(tags_list.size(), 1));
		scrollPane_4.validate();
		scrollPane_4.repaint();
	}
	
	private void showMovieTagValuesResultSetAfterLocation(Connection con) throws SQLException {
		ArrayList<String> tags_list = new ArrayList<String>();
		
		String queryTags1 = "select distinct T.tag_text "
				+ "from Tags T, Movie_tags MT "
				+ "where T.tid = MT.tid and MT.mid in" + "\n" + "((";
		String queryTags2 = "select G.mid from Movie_genres G where ";
		String logicSymbol = "\n" + setLogicSymbol + "\n";
		String queryTags3 = "";
		int count1 = 0;
		
		for (String chooseGenresName: chooseGenres) {
			if (count1 == 0) {
				queryTags3 += queryTags2 + "G.genres = '" + chooseGenresName + "'";
			}
			else {
				queryTags3 += logicSymbol + queryTags2 + "G.genres = '" + chooseGenresName + "'";
			}
			count1 = 1;
		}
		
		String intersect = ")" + "\n" + "intersect" + "\n" + "(";
		String queryTags4 = "select C.mid from Movie_countries C where ";
		String queryTags5 = "";
		int count2 = 0;
		
		for (String chooseCountriesName: chooseCountries) {
			if (count2 == 0) {
				queryTags5 += queryTags4 + "C.country = '" + chooseCountriesName + "'";
			}
			else {
				queryTags5 += logicSymbol + queryTags4 + "C.country = '" + chooseCountriesName + "'";
			}
			count2 = 1;
		}
		
		String queryTags6 = "select L.mid from Movie_locations L where ";
		String queryTags7 = "";
		int count3 = 0;
		
		for (String chooseLocationsName: chooseLocations) {
			if (count3 == 0) {
				queryTags7 += queryTags6 + "L.location_country = '" + chooseLocationsName + "'";
			}
			else {
				queryTags7 += logicSymbol + queryTags6 + "L.location_country = '" + chooseLocationsName + "'";
			}
			count3 = 1;
		}
		
		String queryTags8 = "))" + "\n" + "order by T.tag_text"; 
		String showTagsAfterLocation = queryTags1 + queryTags3 + intersect + queryTags5 + intersect + queryTags7 + queryTags8;
		//System.out.println(showTagsAfterLocation);
		
		Statement stmt = con.createStatement();
		ResultSet tagsResult = stmt.executeQuery(showTagsAfterLocation);
		
		while (tagsResult.next()) { 
			//System.out.println(tagsResult.getString(1));  
			tags_list.add(tagsResult.getString(1));
		}
		
		tags_panel.removeAll();
		
		for (String tagsName: tags_list) {
			JCheckBox tags = new JCheckBox(tagsName);
			tags_panel.add(tags);
			
			tags.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					if (tags.isSelected()) {
						chooseTags.add(tagsName);
					}
				}
			});
		}
		
		tags_panel.setLayout(new GridLayout(tags_list.size(), 1));
		scrollPane_4.validate();
		scrollPane_4.repaint();
	}
	
	private void showMovieTagValuesResultSetAfterRating(Connection con) throws SQLException{
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> tags_list = new ArrayList<String>();
				String ratingRelationSymbol = String.valueOf(comboBox.getSelectedItem());
				String ratingValue = textField.getText();
				
				String updateQueryAfterGenre = "";
				String updateQueryAfterGenrePublic = "select G.mid from Movie_genres G where ";
				String logicSymbol = "\n" + setLogicSymbol + "\n";
				int count1 = 0;
				
				for (String chooseGenresName: chooseGenres) {
					if (count1 == 0) {
						updateQueryAfterGenre += updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					else {
						updateQueryAfterGenre += logicSymbol + updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					count1 = 1;
				}
				
				String updateQueryAfterCountry = "";
				String updateQueryAfterCountryPublic = "select C.mid from Movie_countries C where ";
				int count2 = 0;
				
				for (String chooseCountriesName: chooseCountries) {
					if (count2 == 0) {
						updateQueryAfterCountry += updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					else {
						updateQueryAfterCountry += logicSymbol + updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					count2 = 1;
				}
				
				String updateQueryAfterLocation = "";
				String updateQueryAfterLocationPublic = "select L.mid from Movie_locations L where ";
				int count3 = 0;
				
				for (String chooseLocationsName: chooseLocations) {
					if (count3 == 0) {
						updateQueryAfterLocation += updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					else {
						updateQueryAfterLocation += logicSymbol + updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					count3 = 1;
				}
				
				String updateQuery = "(" + updateQueryAfterGenre + ")";
				if (!chooseCountries.isEmpty()) {
					updateQuery += "\n" + "intersect" + "\n" + "(" + updateQueryAfterCountry + ")";
				}
				if (!chooseLocations.isEmpty()) {
					updateQuery += "\n" + "intersect" + "\n" + "(" + updateQueryAfterLocation + ")";
				}
				
				String showTagsAfterRating = "select distinct T.tag_text from Tags T, Movie_tags MT, Movies M "
						+ "where T.tid = MT.tid and MT.mid = M.mid and M.all_critics_rating " 
						+ ratingRelationSymbol + " " + ratingValue + " and M.mid in" 
						+ "\n" + "(" + updateQuery + ")" + "\n" + "order by tag_text";
				//System.out.println(showTagsAfterRating);
				
				try {
					Statement stmt = con.createStatement();
					ResultSet tagsResult = stmt.executeQuery(showTagsAfterRating);
					while (tagsResult.next()) { 
						try {
							tags_list.add(tagsResult.getString(1));
							//System.out.println(tagsResult.getString(1));
						} catch (SQLException e1) {
							System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
						}
					}
				} catch (SQLException e1) {
					System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
				}
				
				tags_panel.removeAll();
				
				for (String tagsName: tags_list) {
					JCheckBox tags = new JCheckBox(tagsName);
					tags_panel.add(tags);
					
					tags.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent event) {
							if (tags.isSelected()) {
								chooseTags.add(tagsName);
							}
						}
					});
				}
				
				tags_panel.setLayout(new GridLayout(tags_list.size(), 1));
				scrollPane_4.validate();
				scrollPane_4.repaint();
				
				updateQueryAfterRatingNumYear = "select M.mid from Movies M where M.all_critics_rating " + ratingRelationSymbol + " " + ratingValue;
			}
		});
	}
	
	private void showMovieTagValuesResultSetAfterNum(Connection con) throws SQLException{
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> tags_list = new ArrayList<String>();
				String numRelationSymbol = String.valueOf(comboBox_1.getSelectedItem());
				String numValue = textField_1.getText();
				
				String updateQueryAfterGenre = "";
				String updateQueryAfterGenrePublic = "select G.mid from Movie_genres G where ";
				String logicSymbol = "\n" + setLogicSymbol + "\n";
				int count1 = 0;
				
				for (String chooseGenresName: chooseGenres) {
					if (count1 == 0) {
						updateQueryAfterGenre += updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					else {
						updateQueryAfterGenre += logicSymbol + updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					count1 = 1;
				}
				
				String updateQueryAfterCountry = "";
				String updateQueryAfterCountryPublic = "select C.mid from Movie_countries C where ";
				int count2 = 0;
				
				for (String chooseCountriesName: chooseCountries) {
					if (count2 == 0) {
						updateQueryAfterCountry += updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					else {
						updateQueryAfterCountry += logicSymbol + updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					count2 = 1;
				}
				
				String updateQueryAfterLocation = "";
				String updateQueryAfterLocationPublic = "select L.mid from Movie_locations L where ";
				int count3 = 0;
				
				for (String chooseLocationsName: chooseLocations) {
					if (count3 == 0) {
						updateQueryAfterLocation += updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					else {
						updateQueryAfterLocation += logicSymbol + updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					count3 = 1;
				}
				
				String updateQuery = "(" + updateQueryAfterGenre + ")";
				if (!chooseCountries.isEmpty()) {
					updateQuery += "\n" + "intersect" + "\n" + "(" + updateQueryAfterCountry + ")";
				}
				if (!chooseLocations.isEmpty()) {
					updateQuery += "\n" + "intersect" + "\n" + "(" + updateQueryAfterLocation + ")";
				}
				
				String showTagsAfterNum;
				if (updateQueryAfterRatingNumYear.equals("")) {
					showTagsAfterNum = "select distinct T.tag_text from Tags T, Movie_tags MT, Movies M "
							+ "where T.tid = MT.tid and MT.mid = M.mid and M.all_critics_num_review " 
							+ numRelationSymbol + " " + numValue + " and M.mid in" 
							+ "\n" + "(" + updateQuery + ")" + "\n" + "order by tag_text";
				}
				else {
					showTagsAfterNum = "select distinct T.tag_text from Tags T, Movie_tags MT, Movies M "
							+ "where T.tid = MT.tid and MT.mid = M.mid and M.mid in" 
							+ "\n" + "(" + updateQuery + "\n" + "intersect" + "\n" + "(" + updateQueryAfterRatingNumYear 
							+ logicSymbol + "select M.mid from Movies M where M.all_critics_num_review " 
							+ numRelationSymbol + " " + numValue + ")" + ")" + "\n" + "order by tag_text"; 
				}
				//System.out.println(showTagsAfterNum);
				
				try {
					Statement stmt = con.createStatement();
					ResultSet tagsResult = stmt.executeQuery(showTagsAfterNum);
					while (tagsResult.next()) { 
						try {
							tags_list.add(tagsResult.getString(1));
							//System.out.println(tagsResult.getString(1));
						} catch (SQLException e1) {
							System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
						}
					}
				} catch (SQLException e1) {
					System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
				}
				
				tags_panel.removeAll();
				
				for (String tagsName: tags_list) {
					JCheckBox tags = new JCheckBox(tagsName);
					tags_panel.add(tags);
					
					tags.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent event) {
							if (tags.isSelected()) {
								chooseTags.add(tagsName);
							}
						}
					});
				}
				
				tags_panel.setLayout(new GridLayout(tags_list.size(), 1));
				scrollPane_4.validate();
				scrollPane_4.repaint();
				
				if (updateQueryAfterRatingNumYear.equals("")) {
					updateQueryAfterRatingNumYear = "select M.mid from Movies M where M.all_critics_num_review " + numRelationSymbol + " " + numValue;
				}
				else {
					updateQueryAfterRatingNumYear = "(" + updateQueryAfterRatingNumYear + logicSymbol
							+ "select M.mid from Movies M where M.all_critics_num_review " + numRelationSymbol + " " + numValue + ")";
				}
				
			}
		});
	}
	
	private void showMovieTagValuesResultSetAfterYear(Connection con) throws SQLException{
		btnOk_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> tags_list = new ArrayList<String>();
				String fromYear = textField_3.getText();;
				String toYear = textField_4.getText();
				
				String updateQueryAfterGenre = "";
				String updateQueryAfterGenrePublic = "select G.mid from Movie_genres G where ";
				String logicSymbol = "\n" + setLogicSymbol + "\n";
				int count1 = 0;
				
				for (String chooseGenresName: chooseGenres) {
					if (count1 == 0) {
						updateQueryAfterGenre += updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					else {
						updateQueryAfterGenre += logicSymbol + updateQueryAfterGenrePublic + "G.genres = '" + chooseGenresName + "'";
					}
					count1 = 1;
				}
				
				String updateQueryAfterCountry = "";
				String updateQueryAfterCountryPublic = "select C.mid from Movie_countries C where ";
				int count2 = 0;
				
				for (String chooseCountriesName: chooseCountries) {
					if (count2 == 0) {
						updateQueryAfterCountry += updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					else {
						updateQueryAfterCountry += logicSymbol + updateQueryAfterCountryPublic + "C.country = '" + chooseCountriesName + "'";
					}
					count2 = 1;
				}
				
				String updateQueryAfterLocation = "";
				String updateQueryAfterLocationPublic = "select L.mid from Movie_locations L where ";
				int count3 = 0;
				
				for (String chooseLocationsName: chooseLocations) {
					if (count3 == 0) {
						updateQueryAfterLocation += updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					else {
						updateQueryAfterLocation += logicSymbol + updateQueryAfterLocationPublic + "L.location_country = '" + chooseLocationsName + "'";
					}
					count3 = 1;
				}
				
				String updateQuery = "(" + updateQueryAfterGenre + ")";
				if (!chooseCountries.isEmpty()) {
					updateQuery += "\n" + "intersect" + "\n" + "(" + updateQueryAfterCountry + ")";
				}
				if (!chooseLocations.isEmpty()) {
					updateQuery += "\n" + "intersect" + "\n" + "(" + updateQueryAfterLocation + ")";
				}
				if (!updateQueryAfterRatingNumYear.equals("")) {
					updateQuery += "\n" + "intersect" + "\n" + updateQueryAfterRatingNumYear;
				}
				
				String showTagsAfterYear;
				showTagsAfterYear = "select distinct T.tag_text from Tags T, Movie_tags MT, Movies M "
						+ "where T.tid = MT.tid and MT.mid = M.mid and M.year > " + fromYear + " and M.year < " + toYear 
						+ " and M.mid in" + "\n" + "(" + updateQuery + ")" + "\n" + "order by tag_text";
				//System.out.println(showTagsAfterYear);
				
				try {
					Statement stmt = con.createStatement();
					ResultSet tagsResult = stmt.executeQuery(showTagsAfterYear);
					while (tagsResult.next()) { 
						try {
							tags_list.add(tagsResult.getString(1));
							//System.out.println(tagsResult.getString(1));
						} catch (SQLException e1) {
							System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
						}
					}
				} catch (SQLException e1) {
					System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
				}
				
				tags_panel.removeAll();
				
				for (String tagsName: tags_list) {
					JCheckBox tags = new JCheckBox(tagsName);
					tags_panel.add(tags);
					
					tags.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent event) {
							if (tags.isSelected()) {
								chooseTags.add(tagsName);
							}
						}
					});
				}
				
				tags_panel.setLayout(new GridLayout(tags_list.size(), 1));
				scrollPane_4.validate();
				scrollPane_4.repaint();
				
				if (updateQueryAfterRatingNumYear.equals("")) {
					updateQueryAfterRatingNumYear = "select M.mid from Movies M where M.year > " + fromYear + " and M.year < " + toYear;
				}
				else {
					updateQueryAfterRatingNumYear = updateQueryAfterRatingNumYear + "\n" + "intersect" + "\n"
							+ "select M.mid from Movies M where M.year > " + fromYear + " and M.year < " + toYear;
				}
			}
		});
	}
	
	private void runQuery(Connection con) throws SQLException {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					ResultSet executeQueryResult = stmt.executeQuery(showQuery);
					
					String[] meta = new String[8];
					ResultSetMetaData metaData = executeQueryResult.getMetaData(); 
					for (int col = 1; col <= metaData.getColumnCount(); col++) { 
						meta[col-1] = metaData.getColumnName(col); 
					} 
					
					ArrayList<String[]> resultArrList = new ArrayList<String[]>();
					
					while (executeQueryResult.next()) { 
						try {
							String[] rowData = {
									executeQueryResult.getString(1), executeQueryResult.getString(2),
									executeQueryResult.getString(3), executeQueryResult.getString(4),
									executeQueryResult.getString(5), executeQueryResult.getString(6),
									executeQueryResult.getString(7), executeQueryResult.getString(8)
							};
							resultArrList.add(rowData);
						} catch (SQLException e1) {
							System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
						}
					}
					
					Object[][] jtableData = new String[resultArrList.size()][8];
					for (int i = 0; i < resultArrList.size(); i++) {
					    jtableData[i] = resultArrList.get(i);
					}
					
					//System.out.println(Arrays.deepToString(jtableData));
					
					table = new JTable(jtableData, meta);
					scrollPane.setViewportView(table);
					scrollPane.validate();
					scrollPane.repaint();
					
					closeConnection(con);
				} catch (SQLException e1) {
					System.err.println("Errors occurs when communicating with the database server: " + e1.getMessage());
				}
			}
		});
	}
	
	private Connection openConnection() throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

        String host = "localhost";
        String port = "1521";
        String dbName = "ORCL";
        String userName = "xinxin";
        String password = "xinxin";
            
        String dbURL = "jdbc:oracle:thin:@//" + host + ":" + port + "/" + dbName;
        return DriverManager.getConnection(dbURL, userName, password);
    }
	
	private void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println("Cannot close connection: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		main showGui = new main();
		showGui.run();
	}

}
