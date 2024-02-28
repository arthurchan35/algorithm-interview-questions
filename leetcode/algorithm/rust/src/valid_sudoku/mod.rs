pub struct Solution {
}

impl Solution {

	/*
		use given number's indexes to find which sub board of 3 by 3 is the number in.
		ie.
			first sub board is number 0,
			second sub board is number 1, etc

			fn get_square_check_board_indexes(board_ref: &Vec<Vec<char>>, horizontal_index: usize, vertical_index: usize) -> (usize, usize) {
			let a = horizontal_index / 3 * 2 + vertical_index / 3;
			(horizontal_index / 3 * 2 + vertical_index / 3, board_ref[horizontal_index][vertical_index] as usize)
		}
	*/

	pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
		if board.len() != 9 {
			return false;
		}

		let mut vertical_check_board:[[bool; 9]; 9] = [[false; 9]; 9];
		let mut horizontal_check_board:[[bool; 9]; 9] = [[false; 9]; 9];
		let mut square_check_board:[[bool; 9]; 9] = [[false; 9]; 9];

		for horizontal_index in 0.. 9 {

			if board[horizontal_index].len() != 9 {
				return false;
			}

			for vertical_index in 0.. 9 {

				let character = board[horizontal_index][vertical_index];

				if character == '.' {
					continue;
				}

				if  vertical_check_board[vertical_index][character as usize - '1' as usize] {
					return false;
				}

				if horizontal_check_board[horizontal_index][character as usize - '1' as usize] {
					return false;
				}

				if square_check_board[horizontal_index / 3 * 3 + vertical_index / 3][character as usize  - '1' as usize] {
					return false;
				}

				vertical_check_board[vertical_index][character as usize - '1' as usize] = true;

				horizontal_check_board[horizontal_index][character as usize - '1' as usize] = true;

				square_check_board[horizontal_index / 3 * 3 + vertical_index / 3][character as usize - '1' as usize] = true;

			}
		}

		true
	}
}

#[cfg(test)]
mod tests {
use super::Solution;


	#[test]
	fn test() {

		let board = vec![
			vec!['5','3','.','.','7','.','.','.','.'],
			vec!['6','.','.','1','9','5','.','.','.'],
			vec!['.','9','8','.','.','.','.','6','.'],
			vec!['8','.','.','.','6','.','.','.','3'],
			vec!['4','.','.','8','.','3','.','.','1'],
			vec!['7','.','.','.','2','.','.','.','6'],
			vec!['.','6','.','.','.','.','2','8','.'],
			vec!['.','.','.','4','1','9','.','.','5'],
			vec!['.','.','.','.','8','.','.','7','9']
		];

		assert!(Solution::is_valid_sudoku(board));
	}
}