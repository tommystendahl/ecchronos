/*
 * Copyright 2022 Telefonaktiebolaget LM Ericsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ericsson.bss.cassandra.ecchronos.core.repair.types;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@SuppressWarnings("VisibilityModifier")
public class RepairStats
{
    @NotBlank
    public String keyspace;
    @NotBlank
    public String table;
    @NotBlank
    @Min(0)
    @Max(1)
    public double repairedRatio;
    @NotBlank
    @Min(0)
    public long repairTimeTakenMs;

    public RepairStats(final String theKeyspace,
                       final String theTable,
                       final double theRepairedRatio,
                       final long theRepairTimeTakenMs)
    {
        this.keyspace = theKeyspace;
        this.table = theTable;
        this.repairedRatio = theRepairedRatio;
        this.repairTimeTakenMs = theRepairTimeTakenMs;
    }

    /**
     * Equality.
     *
     * @param o The object to compare to.
     * @return boolean
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        RepairStats that = (RepairStats) o;
        return Double.compare(that.repairedRatio, repairedRatio) == 0
                && repairTimeTakenMs == that.repairTimeTakenMs
                && keyspace.equals(that.keyspace)
                && table.equals(that.table);
    }

    /**
     * Hash representation.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(keyspace, table, repairedRatio, repairTimeTakenMs);
    }
}
