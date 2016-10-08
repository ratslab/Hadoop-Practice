a = load '$file' as (line:chararray);
b = foreach a generate flatten(TOKENIZE(line)) as word;
c = group b by word;
d = foreach c generate group, COUNT($1);
d = order d by $0; 
dump d;
