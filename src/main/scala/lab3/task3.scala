package lab3
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_BranchControl extends Bundle {
val fnct3 = Input ( UInt (3. W ) )
val branch = Input ( Bool () )
val arg_x = Input ( UInt (32. W ) )
val arg_y = Input ( UInt (32. W ) )
val br_taken = Output ( Bool () )
}
class task3 extends Module {
    val io = IO ( new LM_IO_Interface_BranchControl )
    //var br = 0.B
    val br = Wire(Bool())
    when(io.arg_x === io.arg_y && io.fnct3 === "b000".U){
        br := true.B
        
    }.elsewhen(io.arg_x =/= io.arg_y && io.fnct3 === "b001".U){
        br := true.B
        
    }.elsewhen(io.arg_x >= io.arg_y && io.fnct3 === "b101".U){
        br := true.B
        
    }.elsewhen(io.arg_x <= io.arg_y & io.fnct3 === "b100".U){
        br := true.B
        
    }.elsewhen(io.arg_x === io.arg_y & io.fnct3 === "b110".U){
        br := true.B
        
    }.elsewhen(io.arg_x === io.arg_y & io.fnct3 === "b111".U){
        br := true.B

    }.otherwise{
        br := false.B
        
    }
io.br_taken := br & io.branch
}
