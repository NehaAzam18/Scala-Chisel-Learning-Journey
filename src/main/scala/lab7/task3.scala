package lab7
import chisel3 . _
import chisel3 . util . _
import chisel3 . experimental . ChiselEnum
import chisel3 . experimental .{
withClock , withReset , withClockAndReset
}
import chisel3 . experimental . BundleLiterals . _

class task3 extends Module {
    // import Manchester_Encoding . State
    // import Manchester_Encoding . State . _
    val io = IO ( new Bundle {
    val in = Input ( UInt (1. W ) )
    val start = Input ( Bool () )
    val out = Output ( UInt (8. W ) )
    //val flag = Output ( UInt (1. W ) )
    })
    
    val s0 :: s1 :: Nil = Enum(2)
    val state = RegInit(s0)
    val outReg = RegInit(0.U(8.W))
    io.out := outReg

    switch(state){
        is(s0){
            io.out := outReg
            //io.flag := 0.U
            when(io.start){
                //io.out := outReg
                state := s1
            }
            }
        is(s1){
            outReg := (outReg << 1) | io.in
            io.out := outReg
            //io.flag := 1.U
            when(~io.start){
                state := s0

        }
    }

}
}