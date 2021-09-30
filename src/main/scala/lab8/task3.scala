package lab8
import chisel3._ 
import chisel3.util._ 

class task3 extends Module{
    val io = IO(new Bundle{
        val addr = Input(UInt(5.W))
        val inst = Input(UInt(32.W))
        val wr_en = Input(Bool())
        val output = Output(UInt(32.W))
    })
    val memory = Mem(32, UInt(32.W))
    when(io.wr_en){
        memory.write(io.addr, io.inst)
    }
    io.output := memory.read(io.addr) 


}