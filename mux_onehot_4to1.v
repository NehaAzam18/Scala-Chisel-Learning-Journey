module mux_onehot_4to1(
  input         clock,
  input         reset,
  input  [31:0] io_in0,
  input  [31:0] io_in1,
  input  [31:0] io_in2,
  input  [31:0] io_in3,
  input  [3:0]  io_sel,
  output [31:0] io_out
);
  wire [31:0] _io_out_T_4 = io_sel[0] ? io_in0 : 32'h0; // @[Mux.scala 27:72]
  wire [31:0] _io_out_T_5 = io_sel[1] ? io_in1 : 32'h0; // @[Mux.scala 27:72]
  wire [31:0] _io_out_T_6 = io_sel[2] ? io_in2 : 32'h0; // @[Mux.scala 27:72]
  wire [31:0] _io_out_T_7 = io_sel[3] ? io_in3 : 32'h0; // @[Mux.scala 27:72]
  wire [31:0] _io_out_T_8 = _io_out_T_4 | _io_out_T_5; // @[Mux.scala 27:72]
  wire [31:0] _io_out_T_9 = _io_out_T_8 | _io_out_T_6; // @[Mux.scala 27:72]
  assign io_out = _io_out_T_9 | _io_out_T_7; // @[Mux.scala 27:72]
endmodule
