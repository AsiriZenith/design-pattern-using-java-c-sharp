﻿using System;
using System.Collections.Generic;
using System.Text;

namespace StrategyDesignPattern2
{
    class AutoTravelStrategy : ITravelStrategy
    {
        public void GotoAirport()
        {
            Console.WriteLine("Traveler is going to Airport by Auto and will be charged Rs 600");
        }
    }
}
