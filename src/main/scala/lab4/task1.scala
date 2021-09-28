package lab4
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_BranchControl extends Bundle {
val fnct3 = Input ( UInt (3. W ) )
val branch = Input ( Bool () )
val arg_x = Input ( UInt (32. W ) )
val arg_y = Input ( UInt (32. W ) )
val br_taken = Output ( Bool () )
}
class task1 extends Module {
    val io = IO ( new LM_IO_Interface_BranchControl )
    //var br = 0.B
    val br = Wire(Bool())
    when(io.arg_x === io.arg_y && io.fnct3 === 0.U){
        br := true.B
        
    }.elsewhen(io.arg_x =/= io.arg_y && io.fnct3 === 1.U){
        br := true.B
        
    }.elsewhen(io.arg_x >= io.arg_y && io.fnct3 === 5.U){
        br := true.B
        
    }.elsewhen(io.arg_x <= io.arg_y & io.fnct3 === 4.U){
        br := true.B
        
    }.elsewhen(io.arg_x <= io.arg_y & io.fnct3 === 6.U){
        br := true.B
        
    }.elsewhen(io.arg_x >= io.arg_y & io.fnct3 === 7.U){
        br := true.B

    }.otherwise{
        br := false.B
        
    }
io.br_taken := br & io.branch
}
