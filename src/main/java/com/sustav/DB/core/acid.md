# ACID

#### Atomicity
- All queries must succeed
- If one fail, all rollback
- If database wend down prior to commit, all succeed queries should rollback

#### Consistency
- Consistency in Data (foreign key)
- Consistency in Read (if committed one tr another will see the changes)
- (eventual consistency)

#### Isolation
- Read uncommitted (no isolation)
- Read committed (only sees committed changes)
- Repeatable read (when query reads a row that row will remain unchanged)
- Snapshot
- Serializable

##### Read phenomena
- Dirty reads 
- Non-repeatable reads
- Phantom reads
- Lost updates
