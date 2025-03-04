def make_integer_from_chars(c1, c2, c3, c4):
    # Only call ord() on characters (strings of length 1)
    output = 0
    output = output | (ord(c1) << 24  if isinstance(c1, str) else c1 << 24)
    output = output | (ord(c2) << 16 if isinstance(c2, str) else c2 << 16)
    output = output | (ord(c3) << 8 if isinstance(c3, str) else c3 << 8)
    output = output | (ord(c4) if isinstance(c4, str) else c4)
    return output

def remap_bits_function(input, remap_bits):
    output = 0
    for i, from_bit in enumerate(remap_bits):
        if 0 <= from_bit < 32:
            bit = (input >> from_bit) & 1
            output |= (bit << i)
    return output

def process_and_display(chars, remap_bits):
    # Reverse the input characters
    local_chars = chars[::-1]

    # Step 1: Create a 32-bit integer from the reversed chars
    bitmask_raw = make_integer_from_chars(local_chars[0], local_chars[1], local_chars[2], local_chars[3])

    # Step 2: Remap the bits
    bitmask_encoded = remap_bits_function(bitmask_raw, remap_bits)

    # Step 3: Display both raw and encoded values
    print(f"Raw Binary representation: {format(bitmask_raw, '032b')}")
    print(f"Raw Integer value: {bitmask_raw}")

    print(f"Encoded Binary representation: {format(bitmask_encoded, '032b')}")
    print(f"Encoded Integer value: {bitmask_encoded}")

# Bit remapping array (example implementation)
remap_bits = [
    0, 8, 16, 24, 1, 9, 17, 25, 2, 10, 18, 26,
    3, 11, 19, 27, 4, 12, 20, 28, 5, 13, 21, 29,
    6, 14, 22, 30, 7, 15, 23, 31
]

# Define test cases using a mix of characters and integers
test_cases = [
    ('A', 0, 0, 0),         # 'A' -> ord('A') = 65
    ('F', 'R', 'E', 'D'),    # 'F', 'R', 'E', 'D' -> ord('F') = 70, ord('R') = 82, ord('E') = 69, ord('D') = 68
    (' ', ':', '^', ')'),    # ' ', ':', '^', ')' -> ord(' ') = 32, ord(':') = 58, ord('^') = 94, ord(')') = 41
    ('f', 'o', 'o', 0),      # 'f', 'o', 'o', 0 -> ord('f') = 102, ord('o') = 111, ord('o') = 111, 0 is already an integer
    (' ', 'f', 'o', 'o'),    # ' ', 'f', 'o', 'o' -> ord(' ') = 32, ord('f') = 102, ord('o') = 111, ord('o') = 111
    ('f', 'o', 'o', 't'),    # 'f', 'o', 'o', 't' -> ord('f') = 102, ord('o') = 111, ord('o') = 111, ord('t') = 116
    ('B', 'I', 'R', 'D'),    # 'B', 'I', 'R', 'D' -> ord('B') = 66, ord('I') = 73, ord('R') = 82, ord('D') = 68
    ('.', '.', '.', '.'),    # '.', '.', '.', '.' -> ord('.') = 46, ord('.') = 46, ord('.') = 46, ord('.') = 46
    ('^', '^', '^', '^'),    # '^', '^', '^', '^' -> ord('^') = 94, ord('^') = 94, ord('^') = 94, ord('^') = 94
    ('W', 'o', 'o', 't'),    # 'W', 'o', 'o', 't' -> ord('W') = 87, ord('o') = 111, ord('o') = 111, ord('t') = 116
    ('n', 'o', 0, 0),        # 'n', 'o', 0, 0 -> ord('n') = 110, ord('o') = 111, 0 is already an integer
    ('r', 'b', 'a', 'i'),    # 'r', 'b', 'a', 'i' -> ord('r') = 114, ord('b') = 98, ord('a') = 97, ord('i') = 105
    ('r', 'o', 'b', 'e')     # 'r', 'o', 'b', 'e' -> ord('r') = 114, ord('o') = 111, ord('b') = 98, ord('e') = 101
]

# Loop over test cases and process them
for test_case in test_cases:
    print(f"Processing array: {test_case}:")
    process_and_display(test_case, remap_bits)
    print()
