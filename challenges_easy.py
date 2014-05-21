import os 
import io

challenges = ['Longest Common Subsequence',
'Prefix expressions',
'String Permutations',
'String Searching',
'Message Decoding',
'String List',
'Ugly Numbers',
'Following Integer',
'Palindromic Ranges',
'Discount Offers',
'Peak Traffic',
'String Substitution',
'Closest Pair',
'Text Dollar',
'Repeated Substring',
'Type Ahead',
'Robot Movements',
'Spiral Printing',
'Levenshtein Distance',
'Telephone Words',
'Grid Walk',
'Decryption',
'Climbing Stairs',
'Word Search',
'Distinct Subsequences',
'Minimum Path Sum',
'Da Vyncy',
'Minesweeper',
'Find Min',
'Poker hands',
'Juggle Fest',
'Commuting Engineer',
'Advanced Calculator',
'Largest Sub-Matrix',
'Computer Terminal',
'Bay Bridges',
'Text to Number',
'Package Problem',
'Seat your team members',
'Skyscrapers',
'Efficient Delivery',
'Play with DNA',
'Code Plagiarism',
'Routing Problem',
'A bus network',
'Flight 370',
'Visit to the Headquarter',
'Digit statistics',
'Fizz Buzz',
'Prime Palindrome',
'Sum of Primes',
'Reverse words',
'Multiples of a Number',
'Bit Positions',
'Lowercase',
'Sum of Digits',
'Fibonacci Series',
'Multiplication Tables',
'Sum of Integers from File',
'Odd Numbers',
'File Size',
'Unique Elements',
'Set Intersection',
'Rightmost Char',
'Happy Numbers',
'N Mod M',
'Armstrong Numbers',
'Beautiful Strings',
'Query Board',
'Simple Sorting',
'Capitalize Words',
'Find a Writer',
'Calculate Distance',
'Even Numbers',
'JSON menu IDs',
'Lowest Unique Number',
'Word to Digit',
'Roman Numerals',
'Shortest Repetition',
'Swap Elements',
'Multiply Lists',
'Mixed Content',
'Morse Code',
'Road Trip',
'Compressed Sequence',
'Split The Number',
'The Major Element',
'Racing Chars',
'Working experience',
'Data Recovery',
'Longest Lines',
'Detecting Cycles',
'Stack Implementation',
'Mth to last element',
'Lowest Common Ancestor',
'First Non-Repeated Character',
'Remove Characters',
'Endianness',
'Number of Ones',
'Sum of integers',
'Decimal To Binary',
'Trailing String',
'Double Squares',
'Number Pairs',
'Email Validation',
'Pangrams',
'Array Absurdity',
'Jolly Jumpers',
'Reverse and Add',
'Prime Numbers',
'Cash Register',
'Counting Primes',
'Pascals Triangle',
'Valid parentheses',
'Overlapping Rectangles',
'Reverse Groups',
'Decode Numbers',
'Minimum Coins',
'Flavius Josephus',
'String Rotation',
'Sudoku',
'URI Comparison',
'Sum to Zero',
'Balanced Smileys',
'Pass Triangle',
'Simple Calculator',
'Point in Circle',
'Find a Square',
'A Pile of Bricks',
'Chain Inspection',
'Lost In Translation',
'Predict the Number',
'Sequence Transformation',
'City Blocks Flyover',
'Word chain',
'Seek for an Intruder',
'Car Race',
'The Ministry of Truth',
'Longest Common Subsequence',
'Prefix expressions',
'String Permutations',
'String Searching',
'Message Decoding',
'String List',
'Ugly Numbers',
'Following Integer',
'Palindromic Ranges',
'Discount Offers',
'Peak Traffic',
'String Substitution',
'Closest Pair',
'Text Dollar',
'Repeated Substring',
'Type Ahead',
'Robot Movements',
'Spiral Printing',
'Levenshtein Distance',
'Telephone Words',
'Grid Walk',
'Decryption',
'Climbing Stairs',
'Word Search',
'Distinct Subsequences',
'Minimum Path Sum',
'Da Vyncy',
'Minesweeper',
'Find Min',
'Poker hands',
'Juggle Fest',
'Commuting Engineer',
'Advanced Calculator',
'Largest Sub-Matrix',
'Computer Terminal',
'Bay Bridges',
'Text to Number',
'Package Problem',
'Seat your team members',
'Skyscrapers',
'Efficient Delivery',
'Play with DNA',
'Code Plagiarism',
'Routing Problem',
'A bus network',
'Flight 370',
'Visit to the Headquarter',
'Digit statistics',
'Fizz Buzz',
'Prime Palindrome',
'Sum of Primes',
'Reverse words',
'Multiples of a Number',
'Bit Positions',
'Lowercase',
'Sum of Digits',
'Fibonacci Series',
'Multiplication Tables',
'Sum of Integers from File',
'Odd Numbers',
'File Size',
'Unique Elements',
'Set Intersection',
'Rightmost Char',
'Happy Numbers',
'N Mod M',
'Armstrong Numbers',
'Beautiful Strings',
'Query Board',
'Simple Sorting',
'Capitalize Words',
'Find a Writer',
'Calculate Distance',
'Even Numbers',
'JSON menu IDs',
'Lowest Unique Number',
'Word to Digit',
'Roman Numerals',
'Shortest Repetition',
'Swap Elements',
'Multiply Lists',
'Mixed Content',
'Morse Code',
'Road Trip',
'Compressed Sequence',
'Split The Number',
'The Major Element',
'Racing Chars',
'Working experience',
'Data Recovery']

DIFFICULTY = 'easy'

sortedAndFiltered = sorted(set(challenges))
for line in sortedAndFiltered:
	packageName = line.replace(' ' ,'').lower()
	print(packageName)
	# os.makedirs('C:/Users/user/Dropbox/CodeEval/src/main/java/' + DIFFICULTY + '/' + packageName)
	challengeClassFile = io.open('C:/Users/user/Dropbox/CodeEval/src/main/java/' + DIFFICULTY + '/' + packageName + '/Main.java', 'w')

	for line in io.open('challenge_class_template.txt', 'r'):
	    line = line.replace('${packageName}', packageName)
	    challengeClassFile.write(line)
	challengeClassFile.close()

