package algorithms.search.graph.knight_on_chess_board;

import org.junit.jupiter.api.Test;

class KnightOnChessBoardTest {

    @Test
    void test() {
        KnightOnChessBoard knightOnChessBoard = new KnightOnChessBoard();
        assert(knightOnChessBoard.knight(8, 8, 1, 1, 8, 8) == 6);
    }
}
