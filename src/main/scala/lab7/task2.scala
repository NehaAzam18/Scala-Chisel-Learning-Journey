package lab7
import chisel3 . _
import chisel3 . util . _

class task2 extends Module {
    val io = IO(new Bundle{
        val f1 = Input(Bool())
        val f2 = Input(Bool())
        val r1 = Input(Bool())
        val r2 = Input(Bool())
        val out = Output(UInt(4.W))
    })
    val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: s6 :: Nil = Enum(7)
    val state = RegInit(s0)
    //io.out := (state === s3) & (!io.in)
    io.out := 0.U

    switch(state){
        is(s0){
            when(io.f1 === 0.B && io.f2 === 0.B){
                state := s0
                io.out := 0.U
            }.elsewhen(io.f1 === 1.B && io.f2 === 0.B){
                state := s1
                io.out := 0.U
            }.elsewhen(io.f1 === 0.B && io.f2 === 1.B){
                state := s5
                io.out := 0.U
            }.elsewhen(io.f1 === 1.B && io.f2 === 1.B){
                state := s1
                io.out := 0.U
            }
        }
        is(s1){
           when(io.f1 === 0.B && io.r1 === 0.B){
                state := s1
                io.out := 0.U
            }.elsewhen(io.f1 === 1.B){
                state := s2
                io.out := 0.U
            }.elsewhen(io.f1 === 0.B && io.r1 === 1.B){
                state := s0
                io.out := 0.U
            } 
        }
        is(s2){
            when(io.f1 === 0.B && io.r1 === 0.B){
                state := s2
                io.out := 3.U
            }.elsewhen(io.f1 === 1.B){
                state := s3
                io.out := 3.U
            }.elsewhen(io.f1 === 0.B && io.r1 === 1.B){
                state := s1
                io.out := 3.U
            }
        }
        is(s3){
            state := s0
            io.out := 0.U
        }
        is(s4){
            when(io.f2 === 1.B){
                state := s3
                io.out := 7.U
            }.elsewhen(io.f2 === 0.B && io.r2 === 0.B){
                state := s3
                io.out := 7.U
            }.elsewhen(io.f2 === 0.B && io.r2 === 1.B){
                state := s5
                io.out := 7.U
            }
        }
        is(s5){
            when(io.f2 === 1.B){
                state := s4
                io.out := 0.U
            }.elsewhen(io.f2 === 0.B && io.r2 === 0.B){
                state := s5
                io.out := 0.U
            }.elsewhen(io.f2 === 0.B && io.r2 === 1.B){
                state := s0
                io.out := 0.U
            }
        }
    }

}


