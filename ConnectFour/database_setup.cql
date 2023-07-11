create keyspace if not exists connectfour with replication = {'class' : 'SimpleStrategy', 'replication_factor' : '1' };

create table if not exists connectfour.game_info (
game_id uuid PRIMARY KEY,
player_one_name text,
player_one_auto boolean,
player_two_name text,
player_two_auto boolean,
create_time timestamp
);

create table if not exists connectfour.board_info (
game_id uuid,
slot_dimension_x int,
slot_dimension_y int,
player_two boolean,
PRIMARY KEY ((game_id), slot_dimension_x, slot_dimension_y)
);

drop table if exists connectfour.game_info;

create table if not exists connectfour.game_info (
game_id uuid PRIMARY KEY,
player_one_name text,
player_one_mode text,
player_two_name text,
player_two_mode text,
create_time timestamp
);

drop table if exists connectfour.board_info;

create table if not exists connectfour.board_info (
game_id uuid,
slot_dimension_x int,
slot_dimension_y int,
player_two boolean,
move_number int,
PRIMARY KEY ((game_id), slot_dimension_x, slot_dimension_y)
);