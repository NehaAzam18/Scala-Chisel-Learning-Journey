package lab5
import chisel3 . _
import chisel3 . util . _
//import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }
class task5 ( Width : Int ) extends Module {
require ( Width >= 0)
val io = IO ( new IO_Interface (Width) )
io.out := io.in1 + io.in2

class IO_Interface(width : Int) extends Bundle {
    val in1 = Input ( UInt ( width . W ) )
    val in2 = Input ( UInt ( width . W ) )
    val out = Output ( UInt ( width . W ) )
}
// your code begin from here
// your code end here
}