module MuxCase_ex(
  input        clock,
  input        reset,
  input        io_in0,
  input        io_in1,
  input        io_in2,
  input        io_in3,
  input        io_in4,
  input        io_in5,
  input        io_in6,
  input        io_in7,
  input  [2:0] io_sel,
  output       io_out
);
  wire  _io_out_T = io_sel == 3'h0; // @[Main.scala 89:12]
  wire  _io_out_T_1 = io_sel == 3'h1; // @[Main.scala 91:12]
  wire  _io_out_T_2 = io_sel == 3'h2; // @[Main.scala 93:12]
  wire  _io_out_T_3 = io_sel == 3'h3; // @[Main.scala 95:12]
  wire  _io_out_T_4 = io_sel == 3'h4; // @[Main.scala 97:12]
  wire  _io_out_T_5 = io_sel == 3'h5; // @[Main.scala 99:12]
  wire  _io_out_T_6 = io_sel == 3'h6; // @[Main.scala 101:12]
  wire  _io_out_T_7 = io_sel == 3'h7; // @[Main.scala 103:12]
  wire  _io_out_T_9 = _io_out_T_6 ? io_in6 : _io_out_T_7 & io_in7; // @[Mux.scala 98:16]
  wire  _io_out_T_10 = _io_out_T_5 ? io_in5 : _io_out_T_9; // @[Mux.scala 98:16]
  wire  _io_out_T_11 = _io_out_T_4 ? io_in4 : _io_out_T_10; // @[Mux.scala 98:16]
  wire  _io_out_T_12 = _io_out_T_3 ? io_in3 : _io_out_T_11; // @[Mux.scala 98:16]
  wire  _io_out_T_13 = _io_out_T_2 ? io_in2 : _io_out_T_12; // @[Mux.scala 98:16]
  wire  _io_out_T_14 = _io_out_T_1 ? io_in1 : _io_out_T_13; // @[Mux.scala 98:16]
  assign io_out = _io_out_T ? io_in0 : _io_out_T_14; // @[Mux.scala 98:16]
endmodule
