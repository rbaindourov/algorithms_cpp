var TimeLimitedCache = function() {
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const currentTime = Date.now();

    if (this.cache.has(key)) {
        const entry = this.cache.get(key);
        if (currentTime < entry.expiration) {
            // Key already exists and hasn't expired
            entry.expiration = currentTime + duration; // Reset expiration time
            entry.value = value;
            return true;
        }
    }

    // Key is either new or has expired
    this.cache.set(key, { value, expiration: currentTime + duration });

    // Remove the key when the expiration time passes
    setTimeout(() => {
        if (this.cache.get(key)?.expiration <= Date.now()) {
            this.cache.delete(key);
        }
    }, duration);

    return false;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    const currentTime = Date.now();
    const entry = this.cache.get(key);

    if (entry && currentTime < entry.expiration) {
        return entry.value;
    }

    return -1; // Return -1 if key doesn't exist or has expired
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    const currentTime = Date.now();
    let count = 0;

    for (const [key, entry] of this.cache.entries()) {
        if (currentTime < entry.expiration) {
            count++;
        } else {
            this.cache.delete(key); // Clean up expired entries
        }
    }

    return count;
};
