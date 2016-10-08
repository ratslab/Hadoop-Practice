a = load '$file' as line:chararray;
--b= foreach a generate line; --STRSPLIT(line,'(\\s+)');
--c = foreach b generate STRSPLIT(line,'(\\s+)') as t;
--d = foreach c generate t.$1,t.;

b= foreach a generate SUBSTRING(line,22,24), SUBSTRING(line,95,98);
c= group b by $0;
d= foreach c generate group,MAX(b.$1);
dump d;

