/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.specification.nukleus.kafka.streams;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

public class FetchIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("scripts", "org/reaktivity/specification/nukleus/kafka/streams/fetch");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Ignore("BEGIN vs RESET read order not yet guaranteed to match write order")
    @Test
    @Specification({
        "${scripts}/begin.ext.missing/client",
        "${scripts}/begin.ext.missing/server"})
    public void shouldRejectWhenBeginExtMissing() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/invalid.topic.name/client",
        "${scripts}/invalid.topic.name/server"})
    public void shouldRejectInvalidTopicName() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/zero.offset/client",
        "${scripts}/zero.offset/server"})
    public void shouldRequestMessagesAtZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/fanout.with.historical.message/client",
        "${scripts}/fanout.with.historical.message/server"})
    public void shouldFanoutUsingHistoricalConnection() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/fanout.with.historical.messages/client",
        "${scripts}/fanout.with.historical.messages/server"})
    public void shouldFanoutDiscardingHistoricalMessageToJoinLiveStream() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/fanout.with.slow.consumer/client",
        "${scripts}/fanout.with.slow.consumer/server"})
    public void shouldFanoutWithSlowConsumer() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/zero.offset.message/client",
        "${scripts}/zero.offset.message/server"})
    public void shouldReceiveMessageAtZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/zero.offset.messages/client",
        "${scripts}/zero.offset.messages/server"})
    public void shouldReceiveMessagesAtZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/zero.offset.messagesets/client",
        "${scripts}/zero.offset.messagesets/server"})
    public void shouldReceiveMessageSetsAtZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/zero.offset.messages.fanout/client",
        "${scripts}/zero.offset.messages.fanout/server"})
    public void shouldFanoutMessagesAtZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/zero.offset.messagesets.fanout/client",
        "${scripts}/zero.offset.messagesets.fanout/server"})
    public void shouldFanoutMessageSetsAtZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/nonzero.offset/client",
        "${scripts}/nonzero.offset/server"})
    public void shouldRequestMessagesAtNonZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/nonzero.offset.message/client",
        "${scripts}/nonzero.offset.message/server"})
    public void shouldReceiveMessageAtNonZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/nonzero.offset.messages/client",
        "${scripts}/nonzero.offset.messages/server"})
    public void shouldReceiveMessagesAtNonZeroOffset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/topic.name.not.equals.route.ext/client",
        "${scripts}/topic.name.not.equals.route.ext/server"})
    public void shouldRejectTopicNameNutEqualToRoutedTopic() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/unknown.topic.name/client",
        "${scripts}/unknown.topic.name/server"})
    public void shouldRejectUnknownTopicName() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/distinct.offset.messagesets.fanout/client",
        "${scripts}/distinct.offset.messagesets.fanout/server"})
    public void shouldFanoutMessageSetsAtDistinctOffsets() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_CLIENT");
        k3po.finish();
    }
}
