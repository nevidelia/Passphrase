package com.nevidelia.library.passphrase;

import java.util.Random;

public class Passphrase {
	
	private final Random random = new Random();
	private final boolean[] settings = {true, true, true, true};
	private int length = 20;
	
	private void applySettings(int member, boolean state) throws IllegalArgumentException {
		if (state) this.settings[member] = state;
		else {
			int count = 0;
			for (int foo = 0; foo < (this.settings.length - 1); foo++)
				if (this.settings[foo]) count++;
			if (count > 1) this.settings[member] = state;
			else throw new IllegalArgumentException("Uppers, Lowers and Numbers cannot be disabled at once.");
		}
	}
	
	public void setUppers(boolean state) throws IllegalArgumentException {
		applySettings(0, state);
	}
	
	public void setLowers(boolean state) throws IllegalArgumentException {
		applySettings(1, state);
	}
	
	public void setNumbers(boolean state) throws IllegalArgumentException {
		applySettings(2, state);
	}
	
	public void setSeparators(boolean state) throws IllegalArgumentException {
		this.settings[3] = state;
	}
	
	public void setLength(int length) throws IllegalArgumentException {
		if (length >= 6 && length <= 60) {
			this.length = length;
		} else throw new IllegalArgumentException("Passphrase length has to be within 6 to 60 digits.");
	}
	
	public String render() {
		StringBuilder stringBuilder = new StringBuilder();
		int separators = 0, length = stringBuilder.toString().length();
		while (length < this.length) {
			int foo = this.random.nextInt(3);
			if (settings[foo]) {
				String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String lowers = "abcdefghijklmnopqrstuvwxyz";
				String numbers = "0123456789";
				switch (foo) {
					case 0:
						foo = this.random.nextInt(uppers.length());
						stringBuilder.append(uppers.charAt(foo));
						break;
					case 1:
						foo = this.random.nextInt(lowers.length());
						stringBuilder.append(lowers.charAt(foo));
						break;
					case 2:
						foo = this.random.nextInt(numbers.length());
						stringBuilder.append(numbers.charAt(foo));
						break;
				}
				if (this.settings[3])
					if ((length + 1) < this.length)
						if (length + 2 != this.length)
							if ((((length + 1) - separators) % 6) == 0) {
								stringBuilder.append('-');
								separators++;
							}
				length = stringBuilder.toString().length();
			}
		} return stringBuilder.toString();
	}
}