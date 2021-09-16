;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit mux_onehot_4to2 : 
  module mux_onehot_4to2 : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in0 : UInt<32>, flip in1 : UInt<32>, flip in2 : UInt<32>, flip in3 : UInt<32>, flip sel : UInt<4>, out : UInt<32>, out2 : UInt<32>}
    
    node _io_out_T = bits(io.sel, 0, 0) @[Mux.scala 29:36]
    node _io_out_T_1 = bits(io.sel, 1, 1) @[Mux.scala 29:36]
    node _io_out_T_2 = bits(io.sel, 2, 2) @[Mux.scala 29:36]
    node _io_out_T_3 = bits(io.sel, 3, 3) @[Mux.scala 29:36]
    node _io_out_T_4 = mux(_io_out_T, io.in0, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out_T_5 = mux(_io_out_T_1, io.in1, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out_T_6 = mux(_io_out_T_2, io.in2, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out_T_7 = mux(_io_out_T_3, io.in3, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out_T_8 = or(_io_out_T_4, _io_out_T_5) @[Mux.scala 27:72]
    node _io_out_T_9 = or(_io_out_T_8, _io_out_T_6) @[Mux.scala 27:72]
    node _io_out_T_10 = or(_io_out_T_9, _io_out_T_7) @[Mux.scala 27:72]
    wire _io_out_WIRE : UInt<32> @[Mux.scala 27:72]
    _io_out_WIRE <= _io_out_T_10 @[Mux.scala 27:72]
    io.out <= _io_out_WIRE @[Main4.scala 19:10]
    node _io_out2_T = bits(io.sel, 0, 0) @[Mux.scala 29:36]
    node _io_out2_T_1 = bits(io.sel, 1, 1) @[Mux.scala 29:36]
    node _io_out2_T_2 = bits(io.sel, 2, 2) @[Mux.scala 29:36]
    node _io_out2_T_3 = bits(io.sel, 3, 3) @[Mux.scala 29:36]
    node _io_out2_T_4 = mux(_io_out2_T, io.in0, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out2_T_5 = mux(_io_out2_T_1, io.in1, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out2_T_6 = mux(_io_out2_T_2, io.in2, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out2_T_7 = mux(_io_out2_T_3, io.in3, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out2_T_8 = or(_io_out2_T_4, _io_out2_T_5) @[Mux.scala 27:72]
    node _io_out2_T_9 = or(_io_out2_T_8, _io_out2_T_6) @[Mux.scala 27:72]
    node _io_out2_T_10 = or(_io_out2_T_9, _io_out2_T_7) @[Mux.scala 27:72]
    wire _io_out2_WIRE : UInt<32> @[Mux.scala 27:72]
    _io_out2_WIRE <= _io_out2_T_10 @[Mux.scala 27:72]
    io.out2 <= _io_out2_WIRE @[Main4.scala 20:10]
    
