package com.csed.calculatorapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class Calc extends ActionBarActivity implements View.OnClickListener {
	final int NONE = -1;
	final int ADD = 0;
	final int SUB = 1;
	final int DIV = 2;
	final int MULTI = 3;
	Button zero, one, two, three, four, five, six, seven, eight, nine, add,
			sub, div, multi, dot, equal,clear;
	String operand1, operand2;
	boolean starting;
	int operator, preOperator;

	boolean dotClicked;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calc);
		display = (TextView) findViewById(R.id.display);
		/* Here, declaring the buttons. */
		zero = (Button) findViewById(R.id.zero);
		one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		add = (Button) findViewById(R.id.add);
		sub = (Button) findViewById(R.id.sub);
		div = (Button) findViewById(R.id.div);
		multi = (Button) findViewById(R.id.multi);
		dot = (Button) findViewById(R.id.dot);
		equal = (Button) findViewById(R.id.equal);
		clear = (Button) findViewById(R.id.clear);
		/*----------------------------------------*/

		zero.setOnClickListener(this);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		add.setOnClickListener(this);
		sub.setOnClickListener(this);
		div.setOnClickListener(this);
		multi.setOnClickListener(this);
		dot.setOnClickListener(this);
		equal.setOnClickListener(this);
		clear.setOnClickListener(this);

		/*----------------------------------------*/
		operand1 = operand2 = "";
		operator = NONE;
		preOperator = NONE;
		dotClicked=false;
		starting = true;
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.zero:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";
				}
				operand1 += "0";
				display.setText(operand1);
			} else {
				operand2 += "0";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.one:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";
				}
				operand1 += "1";
				display.setText(operand1);
			} else {
				operand2 += "1";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.two:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";
				}
				operand1 += "2";
				display.setText(operand1);
			} else {
				operand2 += "2";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.three:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";
				}
				operand1 += "3";
				display.setText(operand1);
			} else {
				operand2 += "3";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.four:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";
				}
				operand1 += "4";
				display.setText(operand1);
			} else {
				operand2 += "4";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.five:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";

				}
				operand1 += "5";
				display.setText(operand1);
			} else {
				operand2 += "5";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.six:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";

				}
				operand1 += "6";
				display.setText(operand1);
			} else {
				operand2 += "6";

				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.seven:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";

				}
				operand1 += "7";
				display.setText(operand1);
			} else {
				operand2 += "7";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.eight:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";

				}
				operand1 += "8";
				display.setText(operand1);
			} else {
				operand2 += "8";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.nine:
			if (operator == NONE) {
				if (starting) {
					operand1 = "";

				}
				operand1 += "9";
				display.setText(operand1);
			} else {
				operand2 += "9";
				display.setText(operand2);
			}
			starting = false;
			break;
		case R.id.dot:
			if (!dotClicked) {
				if (operator == NONE) {
					if (starting) {

						operand1 = "";

					}
					operand1 += ".";
					display.setText(operand1);
				} else {
					operand2 += ".";
					display.setText(operand2);
				}
				dotClicked = true;
				starting = false;
			}
			break;
		case R.id.add:
			operator = ADD;
			result();
			break;
		case R.id.sub:
			if (starting && operand1.equals("")) {
				operand1 = "-";

				display.setText(operand1);
				starting = false;
				break;
			} else if (operator != NONE && preOperator != NONE
					&& operand2.equals("")) {

				operand2 = "-";
				display.setText(operand2);
				starting = false;
				break;
			}

			operator = SUB;
			result();
			break;
		case R.id.div:
			operator = DIV;
			result();
			break;
		case R.id.multi:
			operator = MULTI;
			result();
			break;

		case R.id.equal:
			if (starting)
				break;
			result();
			preOperator = operator = NONE;
			starting = true;

			break;
		case R.id.clear:
			operand1 = operand2 = "";
			operator = NONE;
			preOperator = NONE;
			dotClicked=false;
			starting = true;
			display.setText("");
			break;
		default:
			break;
		}
	}

	private void result() {
		if (operand1.equals(""))
			return;
		if (!operand2.equals("")) {
			switch (preOperator) {
			case ADD:
				operand1 = ""
						+ (Double) (Double.parseDouble(operand1) + Double
								.parseDouble(operand2));
				break;
			case SUB:
				operand1 = ""
						+ (Double) (Double.parseDouble(operand1) - Double
								.parseDouble(operand2));
				break;
			case DIV:
				operand1 = ""
						+ (Double) (Double.parseDouble(operand1) / Double
								.parseDouble(operand2));
				break;
			case MULTI:
				operand1 = ""
						+ (Double) (Double.parseDouble(operand1) * Double
								.parseDouble(operand2));
				break;

			default:
				break;
			}

		}
		operand2 = "";

		display.setText(operand1);
		preOperator = operator;
		dotClicked = false;

	}

}
