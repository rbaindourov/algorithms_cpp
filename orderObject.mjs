import EventEmitter from 'events';

class OrderObject extends EventEmitter {
    constructor() {
        super();
        this.order = {};
    }

    add(item) {
        this.order[item] = (this.order[item] || 0) + 1;
        this.emit('update', this.order);
    }
}



const order = new OrderObject().on('update', (order) => {
    console.log(order);
})

order.add('apple');
order.add('orange');
