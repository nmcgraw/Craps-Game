// Author    : Nick McGraw

#include "stdafx.h"
#include <iostream>
#include <math.h>
#include <windows.h>
#include <sstream>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
using namespace std;

int money = 50, bet, dice1, dice2, roll;

void rollDice();
void pointRoll(int point);
void options();

void _tmain(int argc, _TCHAR* argv[])
{
	cout << "Your initial amount is $50." << endl << "Enter your bet: $";
	cin >> bet;
	rollDice();
}

void rollDice()
{
	srand(time(NULL));
	dice1 = rand() % 6 + 1;
	dice2 = rand() % 6 + 1;
	roll = dice1 + dice2;
	std::string rollStr;
	std::stringstream out;
	out << roll;
	rollStr = out.str();
	cout << "Your first roll is a " + rollStr + "." << endl;
	if (roll == 7 || roll == 11){
		money += bet;
		std::string moneyStr;
		std::stringstream out2;
		out2 << money;
		moneyStr = out2.str();
		cout << "That's a winning score. You now have $" + moneyStr + "." << endl;
	} else if (roll == 2 || roll == 3 || roll == 12){
		money -= bet;
		std::string moneyStr;
		std::stringstream out2;
		out2 << money;
		moneyStr = out2.str();
		cout << "That's a losing score. You now have $" + moneyStr + "." << endl;
	} else {
		pointRoll(roll);
	}
	if (money > 0){
		options();
	} else {
		cout << "You are now broke. Thank you for investing your money with us.";
		Sleep(10000);
	}
}

void pointRoll(int point)
{
	//srand(time(NULL));
	dice1 = rand() % 6 + 1;
	dice2 = rand() % 6 + 1;
	roll = dice1 + dice2;
	std::string rollStr;
	std::stringstream out3;
	out3 << roll;
	rollStr = out3.str();
	cout << "You rolled a " + rollStr + "." << endl;
	if (roll == point){
		money += bet;
		std::string moneyStr;
		std::stringstream out;
		out << money;
		moneyStr = out.str();
		std::string pointStr;
		std::stringstream out2;
		out2 << point;
		pointStr = out2.str();
		cout << "You won by re-rolling a point of " + pointStr + " before rolling a 7. You now have $" + moneyStr + "." << endl;
	} else if (roll == 7){
		money -= bet;
		std::string moneyStr;
		std::stringstream out;
		out << money;
		moneyStr = out.str();
		std::string pointStr;
		std::stringstream out2;
		out2 << point;
		pointStr = out2.str();
		cout << "You lost by rolling a 7 before re-rolling a point of " + pointStr + ". You now have $" + moneyStr + "." << endl;
	} else {
		pointRoll(point);
	}
}

void options()
{
	cout << "Do you wish to roll again? (1) Yes or (2) No: ";
	int choice;
	cin >> choice;
	switch (choice){
	case 1: {
		rollDice();
		break; }
	case 2: {
		std::string moneyStr;
		std::stringstream out;
		out << money;
		moneyStr = out.str();
		cout << "You left the game with $" + moneyStr + ".";
		Sleep (10000);
		break; }
	default: {
		cout << "C'mon, enter 1 or 2." << endl;
		options();
		break; }
	}
}
