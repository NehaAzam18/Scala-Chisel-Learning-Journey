package lab4
import chisel3._ 
import chisel3.util._ 
import scala.language.postfixOps

object ALUOP1 {
    val ALU_ADD = 0.U(4.W)
    val ALU_SUB = 1.U(4.W)
    val ALU_AND = 2.U(4.W)
    val ALU_OR  = 3.U(4.W)
    val ALU_XOR = 4.U(4.W)
    val ALU_SLT = 5.U(4.W)
    val ALU_SLL = 6.U(4.W)
    val ALU_SLTU= 7.U(4.W)
    val ALU_SRL = 8.U(4.W)
    val ALU_SRA = 9.U(4.W)
    val ALU_COPY_A = 10.U(4.W)
    val ALU_COPY_B = 11.U(4.W)
    val ALU_XXX = 12.U(4.W) 
}

trait Config1{
    val WLEN = 32
    val ALUOP_SIG_LEN = 4
}
import ALUOP1 . _
class ALUIO1 extends Bundle with Config1 {
    val in_A = Input(UInt(WLEN.W))
    val in_B = Input(UInt(WLEN.W))
    val alu_Op = Input(UInt(ALUOP_SIG_LEN.W))
    val out = Output(UInt(WLEN.W))
    val sum = Output(UInt(WLEN.W))
}

class task3 extends Module with Config1 {
    val io = IO(new ALUIO1)

    val sum = io.in_A + Mux(io.alu_Op(0), -io.in_B, io.in_B)
    val cmp = Mux(io.in_A(WLEN-1) === io.in_B(WLEN-1), sum(WLEN-1),
                Mux(io.alu_Op(1), io.in_B(WLEN-1), io.in_A(WLEN-1)))
    val shamt = io.in_B(4,0).asUInt
    val shin = Mux(io.alu_Op(3), io.in_A, Reverse(io.in_A))
    val shiftr = (Cat(io.alu_Op(0) && shin(WLEN-1), shin).asSInt >> shamt)(WLEN-1,0)
    val shitfl = Reverse(shiftr)
    val out = 
    Mux(io.alu_Op === ALU_ADD, sum, 
    Mux(io.alu_Op === ALU_SUB, sum,
    Mux(io.alu_Op === ALU_SLT, cmp, 
    Mux(io.alu_Op === ALU_SLTU, cmp,
    Mux(io.alu_Op === ALU_SRA, shiftr,
    Mux(io.alu_Op === ALU_SRL, shiftr,
    Mux(io.alu_Op === ALU_SLL, shitfl, 
    Mux(io.alu_Op === ALU_AND, (io.in_A & io.in_B),
    Mux(io.alu_Op === ALU_OR, (io.in_A | io.in_B),
    Mux(io.alu_Op === ALU_XOR, (io.in_A ^ io.in_B),
    Mux(io.alu_Op === ALU_COPY_A, io.in_A, 
    Mux(io.alu_Op === ALU_COPY_B, io.in_B, 0.U)
    )))))))))))


    io.out := out
    io.sum := sum
}