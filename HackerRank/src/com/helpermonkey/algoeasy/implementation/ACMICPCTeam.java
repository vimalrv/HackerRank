package com.helpermonkey.algoeasy.implementation;

import java.util.Scanner;

public class ACMICPCTeam {

	public static void printoutMaxTopicAndTeam(String[] topics) {
		int maxTopics = 0;
		int maxTeams = 0;

		for (int i = 0; i < topics.length; i++) {
			char[] iElement = topics[i].toCharArray();
			for (int y = i + 1; y < topics.length; y++) {
				char[] yElement = topics[y].toCharArray();
				int sameTopics = 0;

				for (int j = 0; j < iElement.length; j++) {
					if (iElement[j] == '1' || yElement[j] == '1') {
						sameTopics = sameTopics + 1;
					}
				}

				if (maxTopics < sameTopics) {
					maxTopics = sameTopics;
					maxTeams = 0;
				}

				if (sameTopics == maxTopics) {
					maxTeams = maxTeams + 1;
				}
			}
		}
		
		System.out.println(maxTopics);
		System.out.println(maxTeams);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		String[] topics = new String[n];

		for (int i = 0; i < n; i++) {
			topics[i] = in.next();
		}

		printoutMaxTopicAndTeam(topics);
	}
}