package lab2
import chisel3 . _
import chisel3 . util . _


// object Mux_2to1 extends App{
//     println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Main2 () ) )

// }

// Mux IO interface class
class Mux_2to1IO extends Bundle {
val in_A = Input ( UInt (32. W ) )
val in_B = Input ( UInt (32. W ) )
val select = Input ( Bool () )
val out = Output ( UInt () )
}
// 2 to 1 Mux implementation
class Main2 extends Module {
val io = IO ( new Mux_2to1IO )
// update the output
//io . out := Mux ( io . select , io . in_A , io . in_B )
io . out := io . in_A & io . select | io . in_B & (~ io . select )
}
