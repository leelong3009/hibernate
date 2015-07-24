# hibernate DEMO using JPA
1. CRUD: get, load, save, saveOrUpdate, merge
2. Hibernate config hibernate.hbm2ddl.auto: create/update...
3. Embedding Object
4. Proxy Object, Eager & Lazy loading
5. Mapping OneToOne, OneToMany, ManyToMany, mappedBy, cascade
6. Inheritence
7. Transient, Persistent, Detached object
7. HQL, NamedQuery, NamedSQLQuery
8. Creteria

#Transaction, concurrency and caching

###ACID criteria

* **Atomicy**: a bussiness requirement execute many actions. We call these steps collectively a transaction or unit of work. If only one step fails, the whole unit of work must fail. We say that the transaction is atomic.
* **Consistency**: any transaction works with a consistent set of data and leaves the data in a consistent state when the transaction completes.
* **Isolation**: transactions allow multiple users to work concurrently with the same data without compromising the integrity and correctness of the data; a particular transaction shouldn’t be visible to and shouldn’t influence other concurrently running transactions. Several different strategies are used to implement this behavior, which is called isolation.
* **Durability**: Durability guarantees that once a transaction completes, all changes made during that transaction become persistent and aren’t lost even if the system subsequently fails.

####Isolation issue

* *Lost update*: Two transactions both update a row and then the second transaction aborts, causing both changes to be lost. This occurs in systems that don’t implement any locking. The concurrent transactions aren’t isolated.
* *Dirty read*: One transaction reads changes made by another transaction that hasn’t yet been committed. This is very dangerous, because those changes might later be rolled back.
* *Unrepeatable read*: A transaction reads a row twice and reads different state each time. For example, another transaction may have written to the row, and committed, between the two reads.
* *Second lost updates problem*: A special case of an unrepeatable read. Imagine
that two concurrent transactions both read a row, one writes to it and commits, and then the second writes to it and commits. The changes made by the first writer are lost.
* *Phantom read*: A transaction executes a query twice, and the second result set includes rows that weren’t visible in the first result set. (It need not necessarily be exactly the same query.) This situation is caused by another transaction inserting new rows between the execution of the two queries.

####Isolation levels

* *Read uncommitted*: Permits dirty reads but not lost updates. One transaction may not write to a row if another uncommitted transaction has already written to it. Any transaction may read any row, however. This isolation level may be implemented using exclusive write locks.
* *Read committed*: Permits unrepeatable reads but not dirty reads. This may be achieved using momentary shared read locks and exclusive write locks. Reading transactions don’t block other transactions from accessing a row. However, an uncommitted writing transaction blocks all other transactions from accessing the row.
* *Repeatable read*: Permits neither unrepeatable reads nor dirty reads. Phantom reads may occur. This may be achieved using shared read locks and exclusive write locks. Reading transactions block writing transactions (but not other reading transactions), and writing transactions block all other transactions.
* *Serializable*: Provides the strictest transaction isolation. It emulates serial
transaction execution, as if transactions had been executed one after
another, serially, rather than concurrently. Serializability may not be implemented using only row-level locks; there must be another mechanism that prevents a newly inserted row from becoming visible to a transaction that has already executed a query that would return the row.

####Locking

* Pessimistic
* 
